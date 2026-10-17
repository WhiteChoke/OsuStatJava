package com.whitechoke.osuStatJava.Core.db.repository;

import com.whitechoke.osuStatJava.Core.db.entity.PlayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayRepository extends JpaRepository<PlayEntity, Long> {
}
