package com.in4c.HuddleUp.model.Helper;

public class GameModeRequest {
    private String gameName;

    public GameModeRequest(String s) {
        this.gameName = s;
    }

    public GameModeRequest() {
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String s) {
        this.gameName = s;
    }

    @Override
    public String toString() {
        return "GameModeRequest [gameName=" + gameName + "]";
    }
}
