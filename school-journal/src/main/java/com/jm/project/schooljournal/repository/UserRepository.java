package com.jm.project.schooljournal.repository;

import com.jm.project.schooljournal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Override
//    Optional<User> findById(Long aLong);

//    User findByUsername(String name);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
