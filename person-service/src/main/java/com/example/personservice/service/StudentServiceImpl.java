package com.example.personservice.service;

import com.example.personservice.model.Student;
import com.example.personservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService{

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
