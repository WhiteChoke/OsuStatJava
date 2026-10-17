package com.whitechoke.osuStatJava.service;

import com.whitechoke.osuStatJava.db.repository.PlayRepository;
import dev.osureader.model.replay.ReplayModel;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReplayRegisterService {
    private final PlayRepository playRepository;

    @Transactional
    public void replayRegister(ReplayModel replay) {

    }
}
