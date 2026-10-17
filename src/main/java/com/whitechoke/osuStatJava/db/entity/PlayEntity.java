package com.whitechoke.osuStatJava.db.entity;

import dev.osureader.enums.Mods;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import dev.osureader.enums.Grade;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plays")
public class PlayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pp_gained", nullable = false)
    private Double ppGained;

    @Column(name = "combo", nullable = false)
    private Integer combo;

    @Column(name = "accuracy", nullable = false)
    private Double accuracy;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade", nullable = false)
    private Grade grade;

    @Column(name = "played_at")
    private LocalDateTime playedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beatmap_id", nullable = false)
    private BeatmapEntity beatmap;

    @Enumerated(EnumType.STRING)
    @Column(name = "mods")
    private List<Mods> mods;
}
