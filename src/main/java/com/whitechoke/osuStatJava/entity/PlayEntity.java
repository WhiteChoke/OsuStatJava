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

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Plays")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "pp_gained")
    private Double PpGained;
    private Integer Combo;
    private Double Accuracy;
    private Grade Grade;
    private LocalDateTime PlayedAt;
    private Long BeatmapId;
    private List<Mods> Mods;
    private BeatmapEntity Beatmap;
}
