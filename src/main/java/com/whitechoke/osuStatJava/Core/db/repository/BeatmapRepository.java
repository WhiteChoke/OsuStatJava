package com.whitechoke.osuStatJava.Core.db.repository;

import com.whitechoke.osuStatJava.Core.db.entity.BeatmapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeatmapRepository extends JpaRepository<BeatmapEntity, Long> {
}
