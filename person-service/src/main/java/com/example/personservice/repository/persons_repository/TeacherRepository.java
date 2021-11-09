package com.example.personservice.repository.persons_repository;

import com.example.personservice.model.persons.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherByFirstName(String firstName);
}
