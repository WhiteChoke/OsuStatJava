package com.whitechoke.osuStatJava.service;

import com.whitechoke.osuStatJava.db.entity.PlayerStatEntity;
import com.whitechoke.osuStatJava.db.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public void updateStatistic(PlayerStatEntity statistic) {

    }
}
