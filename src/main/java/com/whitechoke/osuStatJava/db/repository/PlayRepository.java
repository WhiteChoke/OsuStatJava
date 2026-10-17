package com.whitechoke.osuStatJava.db.repository;

import com.whitechoke.osuStatJava.db.entity.PlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayRepository extends JpaRepository<PlayEntity, Long> {
}
