package com.debproject.onlineCourses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debproject.onlineCourses.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
