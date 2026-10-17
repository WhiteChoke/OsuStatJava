package com.whitechoke.osuStatJava.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "beatmaps")
@NamedEntityGraph(
        name = "beatmap_with_plays",
        attributeNodes = {
                @NamedAttributeNode("plays")
        }
)
public class BeatmapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mapper", nullable = false)
    private String mapper;

    @Column(name = "length", nullable = false)
    private String length;

    @Column(name = "bpm", nullable = false)
    private Double bpm;

    @Column(name = "star_rate", nullable = false)
    private Double starRate;

    @Column(name = "hp", nullable = false)
    private Double hp;

    @Column(name = "cs", nullable = false)
    private Double cs;

    @Column(name = "ar", nullable = false)
    private Double ar;

    @Column(name = "bgPath", nullable = false)
    private String bgPath;

    @Column(name = "OsuBeatmapId", nullable = false)
    private Long osuBeatmapId;

    @OneToMany(mappedBy = "beatmap", fetch = FetchType.LAZY)
    private List<PlayEntity> plays;
}
