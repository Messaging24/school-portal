package com.example.personservice.service;

import com.example.personservice.model.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student parent);

    void updateStudent(Student parent);

    void deleteStudentById(long id);

    Student getStudentById(long id);

    Student getStudentByName(String name);

    List<Student> getAllStudents();
}
