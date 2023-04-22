package com.debproject.onlineCourses.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.debproject.onlineCourses.entities.Category;
import com.debproject.onlineCourses.entities.Course;
import com.debproject.onlineCourses.entities.Lesson;
import com.debproject.onlineCourses.entities.Section;
import com.debproject.onlineCourses.entities.Student;
import com.debproject.onlineCourses.repositories.CategoryRepository;
import com.debproject.onlineCourses.repositories.CourseRepository;
import com.debproject.onlineCourses.repositories.LessonRepository;
import com.debproject.onlineCourses.repositories.SectionRepository;
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
	private SectionRepository sectionRepository;
	
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
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		courseRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Section sec1_1 = new Section(null, "Secao A", c1);
		Section sec1_2 = new Section(null, "Secao B", c1);
		Section sec2_1 = new Section(null, "Secao A", c2);
		Section sec2_2 = new Section(null, "Secao B", c2);
		Section sec3_1 = new Section(null, "Secao A", c3);
		
		sectionRepository.saveAll(Arrays.asList(sec1_1, sec1_2, sec2_1, sec2_2, sec3_1));
		
		Lesson l1_1 = new Lesson(null, "Identificacao", "00:30", sec1_1);
		Lesson l1_2 = new Lesson(null, "Danos", "00:25", sec1_1);
		Lesson l1_3 = new Lesson(null, "Controle 1", "00:33", sec1_2);
		Lesson l1_4 = new Lesson(null, "Controle 2", "00:28", sec1_2);
		
		Lesson l2_1 = new Lesson(null, "O que são", "00:18", sec2_1);
		Lesson l2_2 = new Lesson(null, "Arados, Subsoladores e Grades", "00:38", sec2_2);
		Lesson l2_3 = new Lesson(null, "Pulverizadores", "00:26", sec2_2);
		Lesson l2_4 = new Lesson(null, "Semeadoras", "00:24", sec2_2);
		
		Lesson l3_1 = new Lesson(null, "Motores", "00:32", sec3_1);
		Lesson l3_2 = new Lesson(null, "Tratores", "00:31", sec2_2);
		Lesson l3_3 = new Lesson(null, "Implementos", "00:29", sec2_2);
		
		
		lessonRepository.saveAll(Arrays.asList(l1_1, l1_2, l1_3, l1_4, l2_1, l2_2, l2_3, l2_4, l3_1, l3_2, l3_3));
		
		
	}
	
	
}
