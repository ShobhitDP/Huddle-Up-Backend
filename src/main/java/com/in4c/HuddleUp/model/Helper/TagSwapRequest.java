package com.in4c.HuddleUp.model.Helper;

public class TagSwapRequest {
    private GameStat gameStat;
    private String usernameRequest;

    public TagSwapRequest() {
    }

    public TagSwapRequest(GameStat gameStat, String usernameRequest) {
        this.gameStat = gameStat;
        this.usernameRequest = usernameRequest;
    }

    public GameStat getGameStat() {
        return gameStat;
    }

    public void setGameStat(GameStat gameStat) {
        this.gameStat = gameStat;
    }

    public String getUsernameRequest() {
        return usernameRequest;
    }

    public void setUsernameRequest(String usernameRequest) {
        this.usernameRequest = usernameRequest;
    }

    @Override
    public String toString() {
        return "TagSwapRequest [gameStat=" + gameStat + ", usernameRequest=" + usernameRequest + "]";
    }

}
