package com.example.personservice.service.persons_services.impl;

import com.example.personservice.model.persons.Teacher;
import com.example.personservice.repository.persons_repository.TeacherRepository;
import com.example.personservice.service.persons_services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public Teacher getTeacherByName(String name) {
        return teacherRepository.findTeacherByName(name);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

}


