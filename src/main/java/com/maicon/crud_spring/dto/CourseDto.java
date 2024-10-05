package com.maicon.crud_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maicon.crud_spring.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CourseDto (
        @JsonProperty("_id") Long id,
        String name, String category) {
}
