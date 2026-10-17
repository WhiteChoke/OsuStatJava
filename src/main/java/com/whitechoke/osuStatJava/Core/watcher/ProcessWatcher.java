package com.whitechoke.osuStatJava.watcher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import oshi.software.os.OperatingSystem;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessWatcher {
    private final OperatingSystem operatingSystem;
    private final ReplayWatcher replayWatcher;
    private boolean isRunning = false;

    @Scheduled(fixedDelay = 500)
    public void checkForProcess() {
        var foundProcesses = operatingSystem.getProcesses(
                process -> process.getName().contains("osu"), null, 0
        );

        if (!foundProcesses.isEmpty()) {
            if (isRunning) return;

            log.info("FOUND OSU PROCESS: {}", foundProcesses);
            replayWatcher.start();
            isRunning = true;
            return;
        }

        if (isRunning)
            replayWatcher.stop();

    }

}
