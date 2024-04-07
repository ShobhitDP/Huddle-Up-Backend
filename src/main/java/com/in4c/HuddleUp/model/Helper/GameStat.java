package com.in4c.HuddleUp.model.Helper;

public class GameStat {
    private int gamesPlayed;
    private int wins;
    private int loses;

    public GameStat() {
    }

    public GameStat(int gamesPlayed, int wins, int loses) {
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.loses = loses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public String toString() {
        return "GameStats [wins=" + wins + ", loses=" + loses + ", gamesPlayed=" + gamesPlayed + "]";
    }
}
