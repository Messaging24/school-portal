package com.jm.project.schooljournal.repository;

import com.jm.project.schooljournal.model.RefreshToken;
import com.jm.project.schooljournal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);
    int deleteByUser(User user);
}
