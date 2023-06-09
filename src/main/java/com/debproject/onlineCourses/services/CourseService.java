package com.debproject.onlineCourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debproject.onlineCourses.entities.Course;
import com.debproject.onlineCourses.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll(){
		return repository.findAll();
	}
	
	public Course findById(Long id) {
		Optional<Course> obj = repository.findById(id);
		return obj.get();
	}
}
