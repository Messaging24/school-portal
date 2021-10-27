package com.example.personservice.repository;

import com.example.personservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Student findTeacherByName(String name);
}
