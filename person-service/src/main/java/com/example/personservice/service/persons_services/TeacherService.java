package com.example.personservice.service.persons_services;

import com.example.personservice.model.persons.Teacher;
import java.util.List;

public interface TeacherService {

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacherById(long id);

    Teacher getTeacherById(long id);

    Teacher getTeacherByName(String name);

    List<Teacher> getAllTeachers();
}

