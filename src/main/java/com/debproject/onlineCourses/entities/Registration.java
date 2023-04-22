package com.debproject.onlineCourses.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.debproject.onlineCourses.entities.enums.Payment;
import com.debproject.onlineCourses.entities.pk.RegistrationPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RegistrationPK id = new RegistrationPK();
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer payment;
	
	public Registration() {
	}

	public Registration(Student student, Course course, Instant moment, Payment payment) {
		super();
		id.setStudent(student);
		id.setCourse(course);
		this.moment = moment;
		setPayment(payment);
	}

	@JsonIgnore
	public Course getCourse() {
		return id.getCourse();
	}
	
	public void setCourse(Course course) {
		id.setCourse(course);
	}
	
	public Student getStudent() {
		return id.getStudent();
	}
	
	public void setStudent(Student student) {
		id.setStudent(student);
	}
	
	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Payment getPayment() {
		return Payment.valueOf(payment);
	}

	public void setPayment(Payment payment) {
		if(payment != null) {
			this.payment = payment.getCode();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(id, other.id);
	}
}
