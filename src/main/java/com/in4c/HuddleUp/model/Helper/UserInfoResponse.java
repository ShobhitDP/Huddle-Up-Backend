package com.in4c.HuddleUp.model.Helper;

public class UserInfoResponse {
    private long ID;
    private String username;
    private int xp;

    public UserInfoResponse(long ID, String username, int xp) {
        this.ID = ID;
        this.username = username;
        this.xp = xp;
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
