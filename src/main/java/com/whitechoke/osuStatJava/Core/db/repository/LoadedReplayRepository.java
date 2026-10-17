package com.whitechoke.osuStatJava.Core.db.repository;

import com.whitechoke.osuStatJava.Core.db.entity.LoadedReplayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface LoadedReplayRepository extends JpaRepository<LoadedReplayEntity, Long> {
    Optional<LoadedReplayEntity> findByDateAndReplayHash(LocalDate replayDate, String replayHash);
}
