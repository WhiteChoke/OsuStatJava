package com.whitechoke.osuStatJava.Core.utils;

import dev.osureader.model.osuDb.OsuBeatmapModel;
import dev.osureader.reader.OsuDbReader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
@Getter
@Component
@AllArgsConstructor
public class Storage {
    private final HashMap<String, OsuBeatmapModel> beatmapsHashMap = new HashMap<>();
    private final OsuDbReader reader;

    public void updateStorage() {
        try {
            var read = reader.read();

            read.beatmaps().forEach(b -> beatmapsHashMap.put(b.beatmapMD5(), b));
            log.info("DATA SUCCESSFULLY UPLOADED");
        } catch (IOException e) {
            log.error("FAILED TO READ OSU.DB: {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
