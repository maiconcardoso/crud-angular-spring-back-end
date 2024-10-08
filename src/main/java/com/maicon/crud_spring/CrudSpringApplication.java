package com.maicon.crud_spring;

import com.maicon.crud_spring.enums.Category;
import com.maicon.crud_spring.model.Course;
import com.maicon.crud_spring.model.Lesson;
import com.maicon.crud_spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication implements CommandLineRunner {

	private final CourseRepository courseRepository;

	public CrudSpringApplication(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		courseRepository.deleteAll();

		Course course = new Course();
		course.setName("Angular com Spring");
		course.setCategory(Category.FRONT_END);

		course.getLessons().add(new Lesson(null, "Introdução", "watch?v=qJnjz8FIs6Q", course));
		course.getLessons().add(new Lesson(null, "Angular", "watch?v=qJnjz8FIddQ", course));

		courseRepository.save(course);
	}
}