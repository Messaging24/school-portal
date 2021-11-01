package com.example.personservice.repository;

import com.example.personservice.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    void deleteByAddress(String address);

    School getSchoolByAddress(String address);

    School getSchoolByNumber(int number);
}
