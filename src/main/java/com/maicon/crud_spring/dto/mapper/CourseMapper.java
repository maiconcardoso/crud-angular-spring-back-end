package com.maicon.crud_spring.dto.mapper;

import com.maicon.crud_spring.dto.CourseDto;
import com.maicon.crud_spring.dto.LessonDto;
import com.maicon.crud_spring.enums.Category;
import com.maicon.crud_spring.enums.Status;
import com.maicon.crud_spring.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseDto toDto(Course course) {
        if (course == null)
            return null;
        List<LessonDto> lessonDtos = course.getLessons().stream()
                .map(c -> new LessonDto(c.getId(), c.getName(), c.getYoutubeUrl()))
                .collect(Collectors.toList());
        return new CourseDto(course.getId(), course.getName(), course.getCategory().getValue(), lessonDtos);
    }

    public Course toEntity(CourseDto courseDto) {
        if (courseDto == null)
            return null;
        Course course = new Course();
        if (courseDto.id() != null) {
            course.setId(courseDto.id());
        }
        course.setName(courseDto.name());
        course.setCategory(convertCategoryValue(courseDto.category()));
        course.setStatus(Status.ACTIVE);
        return course;
    }

    public Category convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }

        return switch (value) {
            case "front-end" -> Category.FRONT_END;
            case "back-end" -> Category.BACK_END;
            default -> throw new IllegalArgumentException("Invalid value: " + value);

        };
    }
}
