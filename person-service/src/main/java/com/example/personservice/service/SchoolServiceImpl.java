package com.example.personservice.service;


import com.example.personservice.model.schoolattributes.School;
import com.example.personservice.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    SchoolRepository schoolRepository;

    @Autowired
    public void setSchoolRepository(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    @Override
    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public void updateSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public void deleteSchoolById(long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public void deleteSchoolByAddress(String address) {
        schoolRepository.deleteByAddress(address);
    }

    @Override
    public School getSchoolById(long id) {
        return schoolRepository.getById(id);
    }

    @Override
    public School getSchoolByAddress(String address) {
        return schoolRepository.getSchoolByAddress(address);
    }

    @Override
    public School getSchoolByNumber(int number) {
        return schoolRepository.getSchoolByNumber(number);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }
}
