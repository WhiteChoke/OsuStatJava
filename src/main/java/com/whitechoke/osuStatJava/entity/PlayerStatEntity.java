package com.whitechoke.osuStatJava.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player_stats")
public class PlayerStatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "play_time_min", nullable = false)
    private Double playTimeMin;

    @Column(name = "map_played", nullable = false)
    private Integer mapPlayed;

    @Column(name = "pp_gained", nullable = false)
    private Integer ppGained;

    @Column(name = "avg_bpm", nullable = false)
    private Double avgBpm;

    @Column(name = "avg_star_rate", nullable = false)
    private Double avgStarRate;

    @Column(name = "avg_accuracy", nullable = false)
    private Double avgAccuracy;

    @Column(name = "session_bpm_sum", nullable = false)
    private Double sessionBpmSum;

    @Column(name = "session_star_rate_sum", nullable = false)
    private Double sessionStarRateSum;

    @Column(name = "session_accuracy_sum", nullable = false)
    private Double sessionAccuracySum;

    @Column(name = "day_initial_pp", nullable = false)
    private Integer dayInitialPp;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
