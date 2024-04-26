package com.in4c.HuddleUp.model.Helper;

public class UpdateUsername {
    private String oldUsername;
    private String newUsername;

    public UpdateUsername(String oldUsername, String newUsername) {
        this.oldUsername = oldUsername;
        this.newUsername = newUsername;
    }

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    @Override
    public String toString() {
        return "UpdateUsername [oldUsername=" + oldUsername + ", newUsername=" + newUsername + "]";
    }
}
