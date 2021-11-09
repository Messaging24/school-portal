package com.example.personservice.service.persons_services;
import com.example.personservice.model.persons.Parent;
import java.util.List;

public interface ParentService {

    void addParent(Parent parent);

    void updateParent(Parent parent);

    void deleteParentById(long id);

    Parent getParentById(long id);

    Parent getParentByFirstName(String name);

    List<Parent> getAllParent();

}