package com.debproject.onlineCourses.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debproject.onlineCourses.entities.Section;
import com.debproject.onlineCourses.services.SectionService;

@RestController
@RequestMapping(value = "/sections")
public class SectionResource {

	@Autowired
	private SectionService service;
	
	@GetMapping
	public ResponseEntity<List<Section>> findAll(){
		List<Section> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Section> findById(@PathVariable Long id){
		Section obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
