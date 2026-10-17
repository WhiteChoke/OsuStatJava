package com.whitechoke.osuStatJava.config;

import dev.osureader.reader.CollectionDbReader;
import dev.osureader.reader.OsuDbReader;
import dev.osureader.reader.ReplayReader;
import dev.osureader.reader.ScoresDbReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class OsuReaderConfig {
    //TODO: implement path load
    private Path gamePath = Paths.get("/home/whitechoke/.local/share/osu-wine/osu!");

    @Bean
    public OsuDbReader osuDbReader() {
        return new OsuDbReader(gamePath.resolve("osu!.db"));
    }

    @Bean
    public CollectionDbReader collectionDbReader() {
        return new CollectionDbReader(gamePath.resolve("collection.db"));
    }

    @Bean
    public ScoresDbReader scoresDbReader() {
        return new ScoresDbReader(gamePath.resolve("scores.db"));
    }

    @Bean
    public ReplayReader replayReader() {
        return new ReplayReader(gamePath);
    }
}
