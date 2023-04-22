package com.debproject.onlineCourses.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.debproject.onlineCourses.entities.Category;
import com.debproject.onlineCourses.entities.Course;
import com.debproject.onlineCourses.entities.Student;
import com.debproject.onlineCourses.repositories.CategoryRepository;
import com.debproject.onlineCourses.repositories.CourseRepository;
import com.debproject.onlineCourses.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Student s1 = new Student(null, "Maria", "maria@gmail.com", "99987444");
		Student s2 = new Student(null, "Joao", "joao@gmail.com", "991918192");
		
		studentRepository.saveAll(Arrays.asList(s1, s2));
		
		Category cat1 = new Category(null, "Controle de Pragas");
		Category cat2 = new Category(null, "Maquinas Agricolas");
		
		Course c1 = new Course(null, "Ervas Daninhas", "Estudo das especies e controle", "Marcos P", cat1);
		Course c2 = new Course(null, "Colheitadeiras", "Tipos, funcionamento e operação", "Fagioli", cat2);
		Course c3 = new Course(null, "Tratores e motores", "Tipos, funcionamento e operação", "Fagioli", cat2);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		courseRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
	}
	
	
}
