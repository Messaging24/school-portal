package com.example.personservice.repository.persons_repository;

import com.example.personservice.model.persons.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByName(String name);
}
