package com.whitechoke.osuStatJava.Core.db.repository;

import com.whitechoke.osuStatJava.Core.db.entity.PlayerStatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PlayerStatRepository extends JpaRepository<PlayerStatEntity, Long> {
    Optional<PlayerStatEntity> findByDate(LocalDate date);
}
