package com.maicon.crud_spring.dto.mapper;

import com.maicon.crud_spring.dto.CourseDto;
import com.maicon.crud_spring.enums.Category;
import com.maicon.crud_spring.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDto toDto(Course course) {
        if (course == null)
            return null;
        return new CourseDto(course.getId(), course.getName(), Category.FRONT_END);
    }

    public Course toEntity(CourseDto courseDto) {
        if (courseDto == null)
            return null;
        Course course = new Course();
        if (courseDto.id() != null) {
            course.setId(courseDto.id());
        }
        course.setName(courseDto.name());
        course.setCategory(Category.FRONT_END);
        course.setStatus("ativo");
        return course;
    }
}
