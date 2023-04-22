package com.debproject.onlineCourses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debproject.onlineCourses.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
