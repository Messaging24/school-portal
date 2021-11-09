package com.example.personservice.controller.persons_controller;

import com.example.personservice.model.persons.Director;
import com.example.personservice.service.persons_services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class DirectorController {

    DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("director/alldirectors")
    public ResponseEntity<List<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @GetMapping("director/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable long id) {
        Director director = directorService.getDirectorById(id);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @PostMapping("director")
    public ResponseEntity<Director> addDirector(@RequestBody Director director) {
        directorService.addDirector(director);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @PutMapping("director")
    public ResponseEntity<Director> updateDirector(@RequestBody Director director) {
        directorService.updateDirector(director);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @DeleteMapping("director")
    public ResponseEntity<Director> deleteDirector(long id) {
        directorService.deleteDirectorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
