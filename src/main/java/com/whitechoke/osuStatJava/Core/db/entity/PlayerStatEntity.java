package com.whitechoke.osuStatJava.Core.db.entity;

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
    private Double playTimeMin = 0.0;

    @Column(name = "map_played", nullable = false)
    private Integer mapPlayed = 0;

    @Column(name = "pp_gained", nullable = false)
    private Double ppGained = 0.0;

    @Column(name = "session_bpm_sum", nullable = false)
    private Integer sessionBpmSum = 0;

    @Column(name = "session_star_rate_sum", nullable = false)
    private Double sessionStarRateSum = 0.0;

    @Column(name = "session_accuracy_sum", nullable = false)
    private Double sessionAccuracySum = 0.0;

    @Column(name = "day_initial_pp", nullable = false)
    private Integer dayInitialPp = 0;

    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date = LocalDate.now();

    public void setPpGained(Double ppGained) {
        this.ppGained += ppGained;
    }

    public void setSessionBpmSum(Integer sessionBpmSum) {
        this.sessionBpmSum += sessionBpmSum;
    }

    public void setSessionStarRateSum(Double sessionStarRateSum) {
        this.sessionStarRateSum += sessionStarRateSum;
    }

    public void setSessionAccuracySum(Double sessionAccuracySum) {
        this.sessionAccuracySum += sessionAccuracySum;
    }

    public void incrementPlayedMap() {
        this.mapPlayed++;
    }
}
