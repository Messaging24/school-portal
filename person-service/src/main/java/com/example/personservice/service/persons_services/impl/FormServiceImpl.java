package com.example.personservice.service.persons_services.impl;

import com.example.personservice.model.schoolattributes.Form;
import com.example.personservice.repository.schoolatribute_repository.FormRepository;
import com.example.personservice.service.schoolatribute_services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    FormRepository formRepository;

    @Autowired
    public void setFormRepository(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    public void addForm(Form form) {
        formRepository.save(form);
    }

    @Override
    public void updateForm(Form form) {
        formRepository.save(form);
    }

    @Override
    public void deleteFormByFormName(String formName) {
        formRepository.deleteFormByFormName(formName);
    }

    @Override
    public void deleteFormById(Long id) {
        formRepository.deleteById(id);
    }

    @Override
    public Form getFormByName(String name) {
        return formRepository.getFormByName(name);
    }

    @Override
    public Form getFormByNumber(int number) {
        return formRepository.getFormByNumber(number);
    }

    @Override
    public Form getFormById(Long id) {
        return formRepository.getById(id);
    }

    @Override
    public Form getFormByFormName(String formName) {
        return formRepository.getFormByFormName(formName);
    }

    @Override
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }


}
