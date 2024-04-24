package com.in4c.HuddleUp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TagSwap")
public class TagSwap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = {
            CascadeType.ALL,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    }, targetEntity = User.class)
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = GameMode.class)
    @JoinColumn(name = "game_id")
    private GameMode gameMode;

    @Column(name = "wins")
    private int wins;

    @Column(name = "losses")
    private int losses;

    @Column(name = "games_played")
    private int gamesPlayed;

    public TagSwap(long id, User user, GameMode gameMode, int wins, int losses, int gamesPlayed) {
        this.id = id;
        this.user = user;
        this.gameMode = gameMode;
        this.wins = wins;
        this.losses = losses;
        this.gamesPlayed = gamesPlayed;
    }

    public TagSwap() {
        // TODO Auto-generated constructor stub
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    @Override
    public String toString() {
        return "TagSwap [id=" + id + ", user=" + user + ", gameMode=" + gameMode + ", wins=" + wins + ", losses="
                + losses + ", gamesPlayed=" + gamesPlayed + "]";
    }
}
