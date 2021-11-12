package com.jm.project.schooljournal.repository;

import com.jm.project.schooljournal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String name);
    User findById(UUID id);
    boolean existsByUsername(String username);
}
