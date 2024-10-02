package com.maicon.crud_spring.service;

import com.maicon.crud_spring.model.Course;
import com.maicon.crud_spring.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class CourseService {

    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> list() {
        return repository.findAll();
    }

    public Optional<Course> findById(@Valid Long id) {
        return repository.findById(id);
    }

    public Course create(@Valid Course record) {
        return repository.save(record);
    }

    public Course update(@Valid Course bodyOfPage, Long id) {
        Optional<Course> courseForUpdated = findById(id);
        if (courseForUpdated.isPresent()) {
            courseForUpdated.get().setName(bodyOfPage.getName());
            courseForUpdated.get().setCategory(bodyOfPage.getCategory());
            return this.create(courseForUpdated.get());
        }
        return null;
    }

    public void delete(@Valid @Positive @NotNull Long id) {
        Optional<Course> courseForDeleted = findById(id);
        if (courseForDeleted.isPresent()) {
            repository.deleteById(id);
        }
    }

}
