package com.example.personservice.service;

import com.example.personservice.model.Parent;
import com.example.personservice.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    ParentRepository parentRepository;

    @Autowired
    public void setParentRepository(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public void addParent(Parent parent) {
        parentRepository.save(parent);
    }

    @Override
    public void updateParent(Parent parent) {
        parentRepository.save(parent);
    }

    @Override
    public void deleteParentById(long id) {
        parentRepository.deleteById(id);
    }

    @Override
    public Parent getParentById(long id) {
        return parentRepository.getById(id);
    }

    @Override
    public Parent getParentByFirstName(String name) {
        return parentRepository.findParentByFirstName(name);
    }

    @Override
    public List<Parent> getAllParent() {
        return parentRepository.findAll();
    }
}
