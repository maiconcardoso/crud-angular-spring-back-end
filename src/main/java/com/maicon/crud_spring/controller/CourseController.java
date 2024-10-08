package com.maicon.crud_spring.controller;

import com.maicon.crud_spring.dto.CourseDto;
import com.maicon.crud_spring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto findById(@PathVariable @NotNull @Positive Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto create(@RequestBody @Valid CourseDto bodyOfPage) {
        return service.create(bodyOfPage);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto update(@RequestBody @Valid CourseDto bodyOfPage, @PathVariable Long id) {
        return service.update(bodyOfPage, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        service.delete(id);
    }
}
