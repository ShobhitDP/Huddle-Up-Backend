package com.in4c.HuddleUp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String emailAddress;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "registeredDate", nullable = false)
    private LocalDate registeredDate;

    @Column(name = "xp", nullable = false)
    private int xp;

    @Column(name = "authenticated", nullable = false)
    private boolean authenticated;

    public User(long id, String username, String password, String email, LocalDate dob, LocalDate registrationDate) {
        this.ID = id;
        this.username = username;
        this.password = password;
        this.emailAddress = email;
        this.dob = dob;
        this.registeredDate = registrationDate;
        this.xp = 0;
        this.authenticated = false;
    }

    public User() {
        //TODO Auto-generated constructor stub
    }

    public long getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public int getXp() {
        return xp;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
