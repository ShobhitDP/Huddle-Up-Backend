package com.in4c.HuddleUp.services;

import com.in4c.HuddleUp.model.User;
import com.in4c.HuddleUp.model.Helper.LoginRequest;
import com.in4c.HuddleUp.model.Helper.SignupRequest;
import com.in4c.HuddleUp.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean userExist(User user) {
        return userRepo.exists(user);
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

    public User signup(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmailAddress(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setXp(0);
        return userRepo.save(user);
    }

    public boolean login(LoginRequest loginRequest) {
        User user = userRepo.findByUsername(loginRequest.getUsername());
        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            user.setAuthenticated(false);
            return false;
        }
        user.setAuthenticated(true);
        return true;
    }

}
