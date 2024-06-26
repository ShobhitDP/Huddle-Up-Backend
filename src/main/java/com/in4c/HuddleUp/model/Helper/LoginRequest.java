package com.in4c.HuddleUp.model.Helper;

public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String u, String p) {
        this.username = u;
        this.password = p;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Request (" + "username: " + this.username + " password: " + this.password + " )";
    }
}
