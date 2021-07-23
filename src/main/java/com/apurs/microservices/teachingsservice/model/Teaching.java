package com.apurs.microservices.teachingsservice.model;

import java.time.ZonedDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "\"teaching\"")
@SequenceGenerator(name = "teaching_id_seq", initialValue = 1, allocationSize = 1)
public class Teaching {
	@Id
	@Column(name = "\"id\"")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teaching_id_seq")
	private int id;
	
	@Column(name = "\"courseId\"")
	private int courseId;
	
	@Column(name = "\"professorId\"")
	private int professorId;
	
	@Column(name = "\"createdAt\"")
	private ZonedDateTime createdAt;
	
	@Column(name = "\"updatedAt\"")
	private ZonedDateTime updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
