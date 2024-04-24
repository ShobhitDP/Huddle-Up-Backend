package com.in4c.HuddleUp.repository;

import com.in4c.HuddleUp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    boolean existsByEmail(String email);

    boolean deleteByUsername(String username);

    void deleteById(Long id);
}
