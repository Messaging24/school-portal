package com.example.personservice.service.schoolatribute_services;

import com.example.personservice.model.schoolattributes.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {
    void addSchool(School school);

    void updateSchool(School school);

    void deleteSchoolById(long id);

    void deleteSchoolByAddress(String address);

    School getSchoolById(long id);

    School getSchoolByAddress(String address);

    School getSchoolByNumber(int number);

    List<School> getAllSchools();


}
