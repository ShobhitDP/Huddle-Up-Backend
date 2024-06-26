package com.in4c.HuddleUp.model.Helper;

import java.time.LocalDate;

public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private LocalDate dob;

    public SignupRequest(String username, String password, String email, LocalDate dob) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "SignupRequest [username=" + username + ", password=" + password + ", email=" + email + ", dob=" + dob
                + "]";
    }

}
