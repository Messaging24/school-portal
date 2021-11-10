package com.example.personservice.service.schoolatribute_services;

import com.example.personservice.model.schoolattributes.Form;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {

    void addForm(Form form);

    void updateForm(Form form);

    void deleteFormByFormName(String formName);

    void deleteFormById(Long id);

    Form getFormByName(String name);

    Form getFormByNumber(int number);

    Form getFormById(Long id);

    Form getFormByFormName(String formName);

    List<Form> getAllForms();

}
