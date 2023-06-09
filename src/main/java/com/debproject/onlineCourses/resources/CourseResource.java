package com.debproject.onlineCourses.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debproject.onlineCourses.entities.Course;
import com.debproject.onlineCourses.services.CourseService;

@RestController
@RequestMapping(value = "/courses")
public class CourseResource {

	@Autowired
	private CourseService service;
	
	@GetMapping
	public ResponseEntity<List<Course>> findAll(){
		List<Course> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Course> findById(@PathVariable Long id){
		Course obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
