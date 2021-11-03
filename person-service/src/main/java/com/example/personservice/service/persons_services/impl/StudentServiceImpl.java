package com.example.personservice.service.persons_services.impl;

import com.example.personservice.model.persons.Student;
import com.example.personservice.repository.persons_repository.StudentRepository;
import com.example.personservice.service.persons_services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
