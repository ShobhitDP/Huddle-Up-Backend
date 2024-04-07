package com.in4c.HuddleUp.services;

import com.in4c.HuddleUp.model.TagSwap;
import com.in4c.HuddleUp.model.Helper.GameStat;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.model.Helper.UserInfoResponse;
import com.in4c.HuddleUp.repository.TagSwapRepository;

public class TagSwapService {
    private TagSwapRepository tagSwapRepo;

    public Result<?> fetchStats(UserInfoResponse obj) {
        TagSwap tagSwap = tagSwapRepo.findByUserID(obj.getID());

        GameStat gameStat = new GameStat(tagSwap.getGamesPlayed(), tagSwap.getWins(), tagSwap.getLosses());

        return new Result<>(true, gameStat, "TagSwap stats fetched successfully!");
    }

    public Result<?> updateStats(GameStat gamestat, UserInfoResponse obj) {
        TagSwap tagSwap = tagSwapRepo.findByUserID(obj.getID());

        tagSwap.setGamesPlayed(tagSwap.getGamesPlayed() + gamestat.getGamesPlayed());
        tagSwap.setWins(tagSwap.getWins() + gamestat.getWins());
        tagSwap.setLosses(tagSwap.getLosses() + gamestat.getLoses());
        tagSwapRepo.save(tagSwap);

        GameStat updatedGameStat = new GameStat(tagSwap.getGamesPlayed(), tagSwap.getWins(), tagSwap.getLosses());

        return new Result<>(true, updatedGameStat, "TagSwap stats updated successfully!");
    }
}
