package com.maicon.crud_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record LessonDto(
        long id,
        @NotNull @NotBlank @Length(min = 5, max = 60) String name,
        @NotNull @NotBlank @Length(min = 10, max = 22) String youtubeUrl
) {
}
