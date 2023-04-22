package com.debproject.onlineCourses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debproject.onlineCourses.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
