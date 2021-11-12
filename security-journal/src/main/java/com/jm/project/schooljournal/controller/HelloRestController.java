package com.jm.project.schooljournal.controller;

import com.jm.project.schooljournal.payload.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRestController {

    @GetMapping("/public")
    public String all() {
        return "Hello";
    }

    @GetMapping("/user")
    public ResponseEntity<?> user() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageResponse("Hello user"));
    }

    @GetMapping("/admin")
    public ResponseEntity<?> admin() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MessageResponse("Hello admin"));
    }
}
