package com.in4c.HuddleUp.services;

import com.in4c.HuddleUp.model.GameMode;
import com.in4c.HuddleUp.model.TagSwap;
import com.in4c.HuddleUp.model.User;
import com.in4c.HuddleUp.model.Helper.LoginRequest;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.model.Helper.SignupRequest;
import com.in4c.HuddleUp.model.Helper.SignupResult;
import com.in4c.HuddleUp.repository.GameModeRepository;
import com.in4c.HuddleUp.repository.TagSwapRepository;
import com.in4c.HuddleUp.repository.UserRepository;

import jakarta.transaction.Transactional;

import com.in4c.HuddleUp.model.Helper.UserInfoResponse;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;
    private TagSwapRepository tagSwapRepo;
    private GameModeRepository gameModeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder, TagSwapRepository tagSwapRepo,
            GameModeRepository gameModeRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tagSwapRepo = tagSwapRepo;
        this.gameModeRepo = gameModeRepo;
    }

    public boolean usernameExist(String username) {
        return userRepo.existsByUsername(username);
    }

    public boolean emailExist(String email) {
        return userRepo.existsByUsername(email);
    }

    @Transactional
    public Result<?> deleteUser(String username) {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            // Delete associated records in tag_swap table
            tagSwapRepo.deleteByUser(user);

            // Now delete the user
            userRepo.delete(user);

            if (userRepo.existsByUsername(username)) {
                return new Result<>(false, null, "Error: user not deleted!");
            }
            return new Result<>(true, null, "Success: user deleted!");
        } else {
            return new Result<>(false, null, "Error: user not found!");
        }
    }

    public Result<?> signup(SignupRequest signupRequest) {
        if (signupRequest.getUsername() == null || signupRequest.getPassword() == null) {
            return new Result<>(false, null, "Error: Missing username or password!");
        }
        if (userRepo.existsByUsername(signupRequest.getUsername())) {
            return new Result<>(false, null, "Error: Username is already taken!");
        }
        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            return new Result<>(false, null, "Error: Email is already taken!");
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setEmail(signupRequest.getEmail());
        user.setDob(signupRequest.getDob());
        user.setRegisteredDate(LocalDate.now());
        user.setXp(0);
        user.setAuthenticated(false);
        userRepo.save(user);

        GameMode gameMode = gameModeRepo.findByGamename("TagSwap");

        TagSwap tagSwap = new TagSwap();
        tagSwap.setUser(user);
        tagSwap.setGameMode(gameMode);
        tagSwap.setGamesPlayed(0);
        tagSwap.setWins(0);
        tagSwap.setLosses(0);
        tagSwapRepo.save(tagSwap);

        SignupResult signupResult = new SignupResult(user.getID(), user.getUsername(), user.getXp(),
                user.getRegisteredDate());

        return new Result<>(true, signupResult, "Success: User was registered successfully!");
    }

    public Result<?> login(LoginRequest loginRequest) {
        User user = userRepo.findByUsername(loginRequest.getUsername());
        if (user == null) {
            return new Result<>(false, null, "Error: user not found!");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new Result<>(false, null, "Error: password is wrong!");
        }
        user.setAuthenticated(true);
        userRepo.save(user);
        return new Result<>(true, new UserInfoResponse(user.getID(), user.getUsername(), user.getXp()), "Success");
    }

    public Result<?> updateUsername(String username, String updatedUsername) {
        User user = userRepo.findByUsername(username);

        // if (!user.isAuthenticated()) {
        // return new Result<>(false, null, "User not authenticated!");
        // }
        user.setUsername(updatedUsername);

        userRepo.save(user);

        return new Result<>(true, new UserInfoResponse(user.getID(), user.getUsername(), user.getXp()),
                "Username updated successfully!");
    }

    public Result<?> logout(String username) {
        User user = userRepo.findByUsername(username);
        user.setAuthenticated(false);

        userRepo.save(user);

        return new Result<>(true, null, "Successfully Logged out!");
    }
}
