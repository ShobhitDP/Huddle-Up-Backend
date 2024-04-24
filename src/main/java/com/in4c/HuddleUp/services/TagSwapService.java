package com.in4c.HuddleUp.services;

import org.springframework.stereotype.Service;

import com.in4c.HuddleUp.model.TagSwap;
import com.in4c.HuddleUp.model.User;
import com.in4c.HuddleUp.model.Helper.GameStat;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.repository.TagSwapRepository;
import com.in4c.HuddleUp.repository.UserRepository;

@Service
public class TagSwapService {
    private UserRepository userRepo;
    private TagSwapRepository tagSwapRepo;

    public TagSwapService(UserRepository userRepo, TagSwapRepository tagSwapRepo) {
        this.userRepo = userRepo;
        this.tagSwapRepo = tagSwapRepo;
    }

    public Result<?> fetchStats(String username) {
        User user = userRepo.findByUsername(username);
        TagSwap tagSwap = tagSwapRepo.findByUserID(user.getID());

        GameStat gameStat = new GameStat(tagSwap.getGamesPlayed(), tagSwap.getWins(), tagSwap.getLosses());

        return new Result<>(true, gameStat, "TagSwap stats fetched successfully!");
    }

    public Result<?> updateStats(GameStat gamestat, String username) {
        User user = userRepo.findByUsername(username);
        TagSwap tagSwap = tagSwapRepo.findByUserID(user.getID());

        tagSwap.setGamesPlayed(tagSwap.getGamesPlayed() + gamestat.getGamesPlayed());
        tagSwap.setWins(tagSwap.getWins() + gamestat.getWins());
        tagSwap.setLosses(tagSwap.getLosses() + gamestat.getLoses());
        tagSwapRepo.save(tagSwap);

        GameStat updatedGameStat = new GameStat(tagSwap.getGamesPlayed(), tagSwap.getWins(), tagSwap.getLosses());

        return new Result<>(true, updatedGameStat, "TagSwap stats updated successfully!");
    }
}
