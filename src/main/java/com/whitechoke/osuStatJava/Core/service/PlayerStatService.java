package com.whitechoke.osuStatJava.Core.service;

import com.whitechoke.osuStatJava.Core.db.entity.PlayerStatEntity;
import com.whitechoke.osuStatJava.Core.db.repository.PlayerStatRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerStatRepository playerRepository;

    @Transactional
    public void updateStatistic(PlayerStatEntity stat) {
        var currentStat = playerRepository.findById(stat.getId());
    }
}
