package com.example.personservice.repository;

import com.example.personservice.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findDirectorByFirstName(String name);
}
