package com.app.lab11_v2.repositories;

import com.app.lab11_v2.models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
}
