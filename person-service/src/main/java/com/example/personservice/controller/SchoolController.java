package com.example.personservice.controller;
import com.example.personservice.model.schoolattributes.School;
import com.example.personservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("school/allschool")
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @GetMapping("school/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable long id) {
        School school = schoolService.getSchoolById(id);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @GetMapping("school/address")
    public ResponseEntity<School> getSchoolByAddress(@PathVariable String address) {
        School school = schoolService.getSchoolByAddress(address);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @GetMapping("school/numbers")
    public ResponseEntity<School> getSchoolByNumber(int number) {
        School school = schoolService.getSchoolByNumber(number);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PostMapping("school/add")
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        schoolService.addSchool(school);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PutMapping("school/edit")
    public ResponseEntity<School> updateDirector(@RequestBody School school) {
        schoolService.updateSchool(school);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @DeleteMapping("school/delete/id")
    public ResponseEntity<School> deleteSchool(long id) {
        schoolService.deleteSchoolById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("school/delete")
    public ResponseEntity<School> deleteSchoolByAddress(String address) {
        schoolService.deleteSchoolByAddress(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}