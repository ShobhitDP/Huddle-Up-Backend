package com.in4c.HuddleUp.services;

import org.springframework.stereotype.Service;

import com.in4c.HuddleUp.model.GameMode;
import com.in4c.HuddleUp.model.Helper.GameModeRequest;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.repository.GameModeRepository;

@Service
public class GameModeService {
    private GameModeRepository gameModeRepo;

    public GameModeService(GameModeRepository gameModeRepo) {
        this.gameModeRepo = gameModeRepo;
    }

    public Result<?> addGameMode(GameModeRequest obj) {
        GameMode gameMode = new GameMode();

        gameMode.setGamename(obj.getGameName());
        gameModeRepo.save(gameMode);

        return new Result<>(true, gameMode, "TagSwap stats updated successfully!");
    }
}
