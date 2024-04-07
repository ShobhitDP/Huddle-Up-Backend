package com.in4c.HuddleUp.services;

import com.in4c.HuddleUp.model.GameMode;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.repository.GameModeRepository;

public class GameModeService {
    private GameModeRepository gameModeRepo;

    public Result<?> addGameMode(GameMode obj) {
        GameMode gameMode = new GameMode(obj.getID(), obj.getGamename());

        gameModeRepo.save(gameMode);

        return new Result<>(true, gameMode, "TagSwap stats updated successfully!");
    }
}
