package com.maicon.crud_spring.service;

import com.maicon.crud_spring.dto.CourseDto;
import com.maicon.crud_spring.dto.mapper.CourseMapper;
import com.maicon.crud_spring.enums.Category;
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
import java.util.stream.Collectors;

@Validated
@Service
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CourseDto> list() {
        return repository.findAll().stream().map(x -> mapper.toDto(x)).collect(Collectors.toList());
    }

    public CourseDto findById(@Valid Long id) {
        return repository.findById(id).map(x -> mapper.toDto(x)).orElseThrow( () -> new RecordNotFoundException(id));
    }

    public CourseDto create(@Valid CourseDto record) {
        return mapper.toDto(repository.save(mapper.toEntity(record)));
    }

    public CourseDto update(@Valid CourseDto bodyOfPage, Long id) {
        return repository.findById(id).map(recordFound -> {
            recordFound.setName(bodyOfPage.name());
            recordFound.setCategory(mapper.convertCategoryValue(bodyOfPage.category()));
            return mapper.toDto(repository.save(recordFound));
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@Valid @Positive @NotNull Long id) {
          repository.delete(repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
