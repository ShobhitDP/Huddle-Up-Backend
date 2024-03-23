package com.in4c.HuddleUp.repository;

import com.in4c.HuddleUp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean exists(User user);

    boolean existsByUsername(String username);

    User findByUsername(String username);

}
