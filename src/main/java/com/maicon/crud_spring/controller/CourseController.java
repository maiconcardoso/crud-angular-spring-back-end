package com.maicon.crud_spring.controller;

import com.maicon.crud_spring.model.Course;
import com.maicon.crud_spring.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Course> list() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course bodyOfPage) {
        bodyOfPage = repository.save(bodyOfPage);
        return ResponseEntity.status(HttpStatus.CREATED).body(bodyOfPage);
    }
}
