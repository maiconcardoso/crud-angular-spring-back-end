package com.maicon.crud_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CourseDto (
        @JsonProperty("_id") Long id,
        @NotNull @NotBlank @Length(min = 5, max = 60) String name,
        @NotNull @NotBlank String category,
        @NotNull @NotEmpty @NotBlank List<LessonDto> lessons) {
}
