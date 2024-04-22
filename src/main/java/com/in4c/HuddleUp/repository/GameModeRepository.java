package com.in4c.HuddleUp.repository;

import com.in4c.HuddleUp.model.GameMode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameModeRepository extends JpaRepository<GameMode, Long> {
    GameMode findByGamename(String gameName);
}
