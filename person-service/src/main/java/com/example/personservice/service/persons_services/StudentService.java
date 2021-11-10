package com.example.personservice.service.persons_services;

import com.example.personservice.model.persons.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    void addStudent(Student parent);

    void updateStudent(Student parent);

    void deleteStudentById(long id);

    Student getStudentById(long id);

    Student getStudentByName(String name);

    List<Student> getAllStudents();
}
