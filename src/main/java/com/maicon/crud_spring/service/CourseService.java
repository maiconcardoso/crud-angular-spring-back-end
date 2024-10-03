package com.maicon.crud_spring.service;

import com.maicon.crud_spring.exception.RecordNotFoundException;
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

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> list() {
        return repository.findAll();
    }

    public Course findById(@Valid Long id) {
        return repository.findById(id).orElseThrow( () -> new RecordNotFoundException(id));
    }

    public Course create(@Valid Course record) {
        return repository.save(record);
    }

    public Course update(@Valid Course bodyOfPage, Long id) {
        Course courseForUpdated = findById(id);
        courseForUpdated.setName(bodyOfPage.getName());
        courseForUpdated.setCategory(bodyOfPage.getCategory());
        return this.create(courseForUpdated);

    }

    public void delete(@Valid @Positive @NotNull Long id) {
          repository.delete(findById(id));
    }
}
