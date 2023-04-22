package com.debproject.onlineCourses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debproject.onlineCourses.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
