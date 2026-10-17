package com.whitechoke.osuStatJava.db.repository;

import com.whitechoke.osuStatJava.db.entity.BeatmapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<BeatmapEntity, Long> {
}
