package com.debproject.onlineCourses.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Course implements Serializable {
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String teacher;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany (mappedBy = "course")
	private Set<Section> sections = new HashSet<>();
	
	@OneToMany(mappedBy = "id.course")
	private Set<Registration> registrations = new HashSet<>();
	
	public Course() {
	}

	public Course(Long id, String name, String description, String teacher, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.teacher = teacher;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<Section> getSection() {
		return sections;
	}
	
	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public String getTotalDuration() {
		int sumHours = 0;
		int sumMinutes = 0; 
		for(Section x : sections) {
			String[] fields = x.getSubTotalDuration().split("[hm]+");
			int hours = Integer.parseInt(fields[0]);
			int minutes = Integer.parseInt(fields[1]);
			sumHours += hours;
			sumMinutes += minutes;
		}
		if(sumMinutes >= 60) {
			int result = (int) sumMinutes/60;
			sumHours += result;
			sumMinutes = sumMinutes%60;
		}
			String duration = Integer.toString(sumHours) + "h" + Integer.toString(sumMinutes) + "m";
			return duration;
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
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}

}
