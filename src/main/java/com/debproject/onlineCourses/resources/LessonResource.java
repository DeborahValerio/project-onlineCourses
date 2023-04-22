package com.debproject.onlineCourses.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debproject.onlineCourses.entities.Lesson;
import com.debproject.onlineCourses.services.LessonService;

@RestController
@RequestMapping(value = "/lessons")
public class LessonResource {

	@Autowired
	private LessonService service;
	
	@GetMapping
	public ResponseEntity<List<Lesson>> findAll(){
		List<Lesson> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lesson> findById(@PathVariable Long id){
		Lesson obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
