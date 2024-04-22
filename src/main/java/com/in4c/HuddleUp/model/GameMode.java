package com.in4c.HuddleUp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GameMode")
public class GameMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "gamename", unique = true, nullable = false)
    private String gamename;

    public GameMode(long iD, String gamename) {
        ID = iD;
        this.gamename = gamename;
    }

    public GameMode() {
        //TODO Auto-generated constructor stub
    }

    public long getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    @Override
    public String toString() {
        return "GameMode [ID=" + ID + ", gamename=" + gamename + "]";
    }
}
