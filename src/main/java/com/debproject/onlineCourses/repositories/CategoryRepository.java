package com.debproject.onlineCourses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debproject.onlineCourses.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
