package com.maicon.crud_spring.dto.mapper;

import com.maicon.crud_spring.dto.CourseDto;
import com.maicon.crud_spring.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDto toDto(Course course) {
        if (course == null)
            return null;
        return new CourseDto(course.getId(), course.getName(), course.getCategory());
    }

    public Course toEntity(CourseDto courseDto) {
        if (courseDto == null)
            return null;
        Course course = new Course();
        if (courseDto.id() != null) {
            course.setId(courseDto.id());
        }
        course.setName(courseDto.name());
        course.setCategory(courseDto.category());
        course.setStatus("ativo");
        return course;
    }
}
