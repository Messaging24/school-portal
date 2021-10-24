package com.example.personservice.service;

import com.example.personservice.model.Director;

import java.util.List;

public interface DirectorService {

    void addDirector(Director director);

    void updateDirector(Director director);

    void deleteDirectorById(long id);

    Director getDirectorById(long id);

    Director getDirectorByFirstName(String name);

    List<Director> getAllDirectors();

}
