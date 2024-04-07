package com.in4c.HuddleUp.services;

import com.in4c.HuddleUp.model.GameMode;
import com.in4c.HuddleUp.model.TagSwap;
import com.in4c.HuddleUp.model.User;
import com.in4c.HuddleUp.model.GameMode;
import com.in4c.HuddleUp.model.Helper.LoginRequest;
import com.in4c.HuddleUp.model.Helper.Result;
import com.in4c.HuddleUp.model.Helper.SignupRequest;
import com.in4c.HuddleUp.repository.TagSwapRepository;
import com.in4c.HuddleUp.repository.UserRepository;
import com.in4c.HuddleUp.model.Helper.UserInfoResponse;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;
    private TagSwapRepository tagSwapRepo;
    private GameMode gameMode = new GameMode(1, "TagSwap");
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder, TagSwapRepository tagSwapRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tagSwapRepo = tagSwapRepo;
    }

    public boolean usernameExist(String username) {
        return userRepo.existsByUsername(username);
    }

    public boolean emailExist(String email) {
        return userRepo.existsByUsername(email);
    }

    public boolean deleteUser(Long userId) {
        @SuppressWarnings("unused")
        boolean existed = userRepo.existsById(userId);
        userRepo.deleteById(userId);
        return !userRepo.existsById(userId);
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

        TagSwap tagSwap = new TagSwap();
        tagSwap.setUser(user);
        tagSwap.setGameMode(gameMode);
        tagSwap.setGamesPlayed(0);
        tagSwap.setWins(0);
        tagSwap.setLosses(0);
        tagSwapRepo.save(tagSwap);

        return new Result<>(true, user, "Success: User was registered successfully!");
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
}
