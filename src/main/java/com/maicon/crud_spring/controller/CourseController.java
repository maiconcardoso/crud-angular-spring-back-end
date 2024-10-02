package com.maicon.crud_spring.controller;

import com.maicon.crud_spring.model.Course;
import com.maicon.crud_spring.repository.CourseRepository;
import com.maicon.crud_spring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable @NotNull @Positive Long id) {
        return service.findById(id)
                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody @Valid Course bodyOfPage) {
        bodyOfPage = service.create(bodyOfPage);
        return ResponseEntity.status(HttpStatus.CREATED).body(bodyOfPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@RequestBody @Valid Course bodyOfPage, @PathVariable Long id) {
        Course courseForUpdated = service.update(bodyOfPage, id);
        return ResponseEntity.status(HttpStatus.OK).body(courseForUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
