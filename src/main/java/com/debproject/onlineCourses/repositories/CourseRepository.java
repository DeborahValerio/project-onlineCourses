package com.debproject.onlineCourses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debproject.onlineCourses.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
