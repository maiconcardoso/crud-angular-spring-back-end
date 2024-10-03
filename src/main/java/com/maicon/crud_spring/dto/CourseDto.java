package com.maicon.crud_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CourseDto (
        @JsonProperty("_id") Long id,
        @NotNull @NotBlank @Length(min = 5, max = 60) String name,
        @NotNull @NotBlank @Pattern(regexp = "back-end|front-end") @Length(max = 15) String category) {
}
