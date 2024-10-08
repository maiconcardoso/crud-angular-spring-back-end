package com.maicon.crud_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CourseDto (
        Long id,
        String name, String category, List<LessonDto> lessons) {
}
