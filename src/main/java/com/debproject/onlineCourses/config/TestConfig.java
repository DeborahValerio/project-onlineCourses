package com.debproject.onlineCourses.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.debproject.onlineCourses.entities.Student;
import com.debproject.onlineCourses.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Student s1 = new Student(null, "Maria", "maria@gmail.com", "99987444");
		Student s2 = new Student(null, "Joao", "joao@gmail.com", "991918192");
		
		studentRepository.saveAll(Arrays.asList(s1, s2));
		
	}
	
	
}
