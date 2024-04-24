package com.in4c.HuddleUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.in4c.HuddleUp.model.TagSwap;
import com.in4c.HuddleUp.model.User;

public interface TagSwapRepository extends JpaRepository<TagSwap, Long> {
    TagSwap findByUserID(long ID);

    void deleteByUser(User user);
}
