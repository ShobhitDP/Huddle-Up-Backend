package com.in4c.HuddleUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.in4c.HuddleUp.model.TagSwap;

public interface TagSwapRepository extends JpaRepository<TagSwap, Long> {
    TagSwap findByUserID(long ID);
}
