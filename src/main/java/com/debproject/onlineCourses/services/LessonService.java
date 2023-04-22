package com.debproject.onlineCourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debproject.onlineCourses.entities.Lesson;
import com.debproject.onlineCourses.repositories.LessonRepository;

@Service
public class LessonService {

	@Autowired
	private LessonRepository repository;

	public List<Lesson> findAll() {
		return repository.findAll();
	}

	public Lesson findById(Long id) {
		Optional<Lesson> obj = repository.findById(id);
		return obj.get();
	}
}
