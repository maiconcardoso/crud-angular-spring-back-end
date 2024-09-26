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

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course bodyOfPage) {
        bodyOfPage = repository.save(bodyOfPage);
        return ResponseEntity.status(HttpStatus.CREATED).body(bodyOfPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@RequestBody Course bodyOfPage, @PathVariable Long id) {
        Course courseForUpdated = new Course();
        if (repository.findById(id).isPresent()) {
            courseForUpdated = repository.findById(id).get();
        }
        courseForUpdated.setName(bodyOfPage.getName());
        courseForUpdated.setCategory(bodyOfPage.getCategory());
        courseForUpdated = repository.save(courseForUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(courseForUpdated);
    }
}
