package com.debproject.onlineCourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.debproject.onlineCourses.entities.Student;
import com.debproject.onlineCourses.repositories.StudentRepository;
import com.debproject.onlineCourses.services.exceptions.DatabaseException;
import com.debproject.onlineCourses.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Student insert(Student obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
			}
			else {
				throw new ResourceNotFoundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Student update(Long id, Student obj) {
		try {
			Student entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Student entity, Student obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
