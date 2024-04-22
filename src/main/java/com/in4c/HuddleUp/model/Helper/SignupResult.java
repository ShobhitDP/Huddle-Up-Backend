package com.in4c.HuddleUp.model.Helper;

import java.time.LocalDate;

public class SignupResult {
    private long ID;
    private String username;
    private int xp;
    private LocalDate registeredDate;

    public SignupResult(long ID, String username, int xp, LocalDate registeredDate) {
        this.ID = ID;
        this.username = username;
        this.xp = xp;
        this.registeredDate = registeredDate;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
