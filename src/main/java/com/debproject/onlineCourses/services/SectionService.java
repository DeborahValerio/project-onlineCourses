package com.debproject.onlineCourses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debproject.onlineCourses.entities.Section;
import com.debproject.onlineCourses.repositories.SectionRepository;

@Service
public class SectionService {

	@Autowired
	private SectionRepository repository;

	public List<Section> findAll() {
		return repository.findAll();
	}

	public Section findById(Long id) {
		Optional<Section> obj = repository.findById(id);
		return obj.get();
	}
}
