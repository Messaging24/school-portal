package com.example.personservice.service.persons_services;

import com.example.personservice.model.persons.Director;

import java.util.List;

public interface DirectorService {

    void addDirector(Director director);

    void updateDirector(Director director);

    void deleteDirectorById(long id);

    Director getDirectorById(long id);

    // TODO: 25.10.2021   вынести поиск директора по уникальному имени в отдельную задачу.
    Director getDirectorByFirstName(String name);

    List<Director> getAllDirectors();

}
