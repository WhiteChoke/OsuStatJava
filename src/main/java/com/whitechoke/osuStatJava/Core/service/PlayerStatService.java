package com.whitechoke.osuStatJava.Core.service;

import com.whitechoke.osuStatJava.Core.db.entity.PlayerStatEntity;
import com.whitechoke.osuStatJava.Core.db.repository.PlayerStatRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public class PlayerStatService {
    private final PlayerStatRepository playerRepository;

    @Transactional
    public void updateStatistic(
            double accuracy,
            double starRate,
            int bpm,
            double pp
    ) {
        var currentStat = playerRepository.findByDate(LocalDate.now())
                .orElseThrow(() -> new EntityNotFoundException("Player statistic not found"));

        currentStat.setSessionAccuracySum(accuracy);
        currentStat.setSessionStarRateSum(starRate);
        currentStat.setSessionBpmSum(bpm);
        currentStat.setPpGained(pp);
        currentStat.incrementPlayedMap();

        log.info("PLAYER STATISTICS UPDATED");
        log.info(currentStat.toString());
    }

    @PostConstruct
    @Transactional
    private void CheckData() {
        var todayStat = playerRepository.findByDate(LocalDate.now());

        if(todayStat.isPresent()) return;

        playerRepository.save(new PlayerStatEntity());
    }

}
