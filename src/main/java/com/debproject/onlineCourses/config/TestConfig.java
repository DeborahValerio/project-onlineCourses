package com.debproject.onlineCourses.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.debproject.onlineCourses.entities.Category;
import com.debproject.onlineCourses.entities.Course;
import com.debproject.onlineCourses.entities.Lesson;
import com.debproject.onlineCourses.entities.Student;
import com.debproject.onlineCourses.repositories.CategoryRepository;
import com.debproject.onlineCourses.repositories.CourseRepository;
import com.debproject.onlineCourses.repositories.LessonRepository;
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
	
	@Autowired
	private LessonRepository lessonRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Student s1 = new Student(null, "Maria", "maria@gmail.com", "99987444");
		Student s2 = new Student(null, "Joao", "joao@gmail.com", "991918192");
		
		studentRepository.saveAll(Arrays.asList(s1, s2));
		
		Category cat1 = new Category(null, "Controle de Pragas");
		Category cat2 = new Category(null, "Maquinas Agricolas");
		
		Course c1 = new Course(null, "Ervas Daninhas", "Estudo das especies e controle", "Marcos P", cat1);
		Course c2 = new Course(null, "Implementos agricolas", "Tipos e operacao", "Fagioli", cat2);
		Course c3 = new Course(null, "Tratores e motores", "Modelos, funcionamento e operacao", "Fagioli", cat2);
		
		Lesson l11 = new Lesson(null, "Identificacao", "00:30", c1);
		Lesson l12 = new Lesson(null, "Danos", "00:25", c1);
		Lesson l13 = new Lesson(null, "Controle 1", "00:33", c1);
		Lesson l14 = new Lesson(null, "Controle 2", "00:28", c1);
		
		Lesson l21 = new Lesson(null, "O que são", "00:18", c2);
		Lesson l22 = new Lesson(null, "Arados, Subsoladores e Grades", "00:38", c2);
		Lesson l23 = new Lesson(null, "Pulverizadores", "00:26", c2);
		Lesson l24 = new Lesson(null, "Semeadoras", "00:24", c2);
		
		Lesson l31 = new Lesson(null, "Motores", "00:32", c3);
		Lesson l32 = new Lesson(null, "Tratores", "00:31", c3);
		Lesson l33 = new Lesson(null, "Implementos", "00:29", c3);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		courseRepository.saveAll(Arrays.asList(c1, c2, c3));
		lessonRepository.saveAll(Arrays.asList(l11, l12, l13, l14, l21, l22, l23, l24, l31, l32, l33));
		
		
	}
	
	
}
