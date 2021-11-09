package com.example.personservice.controller.persons_controller;

import com.example.personservice.model.persons.Teacher;
import com.example.personservice.service.persons_services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("teacher/allteachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("teacher/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PutMapping("teacher/edit")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @DeleteMapping("teacher/delete")
    public ResponseEntity<Teacher> deleteTeacher(long id) {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


