package com.debproject.onlineCourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debproject.onlineCourses.entities.Student;
import com.debproject.onlineCourses.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.get();
	}
}
