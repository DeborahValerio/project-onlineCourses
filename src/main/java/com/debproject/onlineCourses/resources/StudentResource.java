package com.debproject.onlineCourses.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debproject.onlineCourses.entities.Student;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {

	@GetMapping
	public ResponseEntity<Student> findAll(){
		Student s = new Student(1L, "Maria", "maria@gmail.com", "99987449");
		return ResponseEntity.ok().body(s);
	}
	
	
}
