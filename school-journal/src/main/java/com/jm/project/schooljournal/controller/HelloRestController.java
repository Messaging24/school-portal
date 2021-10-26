package com.jm.project.schooljournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloRestController {
    @GetMapping
    public String getAll() {
        return "public HELLO";
    }
}
