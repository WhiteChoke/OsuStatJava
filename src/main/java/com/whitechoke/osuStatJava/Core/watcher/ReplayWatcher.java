package com.whitechoke.osuStatJava.watcher;

import dev.osureader.reader.ReplayReader;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReplayWatcher {
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private final ReplayReader replayReader;
    private WatchService watcher;
    private Path replayFolder = Paths.get("/home/whitechoke/.local/share/osu-wine/osu!/Data/r");

    public void start() {
        try {
            watcher = FileSystems.getDefault().newWatchService();
            replayFolder.register(
                    watcher,
                    StandardWatchEventKinds.ENTRY_CREATE
            );
            var key = watcher.take();

            executor.scheduleWithFixedDelay(() -> watch(key), 0, 500, TimeUnit.MILLISECONDS);
        } catch (IOException e) {
            log.error("FAILED TO START REPLAY WATCHER CAUSE: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            //TODO
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void stop() {
        try {
            watcher.close();
        } catch (IOException e) {
            log.error("FAILED TO STOP REPLAY WATCHER: {}", e.getMessage());
        }
        executor.shutdown();
    }

    private void watch(WatchKey key) {
        if (watcher == null) {
            throw new IllegalStateException("Watcher has not been initialized");
        }

        try {
            List<WatchEvent<?>> event = key.pollEvents().stream()
                    .filter(e -> e.context().toString().endsWith(".osr")
                            && e.kind() != StandardWatchEventKinds.OVERFLOW
                    ).toList();

            if (event.isEmpty()) {
                return;
            }


            replayReader.setFilePath(
                    Paths.get(replayFolder.toString(), event.getLast().context().toString())
            );

            log.info("FOUND NEW REPLAY: {}", replayReader.getFilePath());

            var read = replayReader.read();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            replayReader.setFilePath(null);
            key.reset();
        }
    }
}
