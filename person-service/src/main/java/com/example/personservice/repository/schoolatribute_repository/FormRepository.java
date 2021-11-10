package com.example.personservice.repository.schoolatribute_repository;

import com.example.personservice.model.schoolattributes.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    Form getFormByFormName(String formName);

    void deleteFormByFormName(String formName);

    Form getFormByName(String name);

    Form getFormByNumber(int number);
}
