package com.example.personservice.repository.persons_repository;

import com.example.personservice.model.persons.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    Parent findParentByFirstName(String name);
}