package com.apurs.microservices.teachingsservice.dto;

import java.time.ZonedDateTime;

public class TeachingCreateDTO {
	private int courseId;
	private int professorId;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	public TeachingCreateDTO(int courseId, int professorId) {
		super();
		this.courseId = courseId;
		this.professorId = professorId;
		this.setCreatedAt(ZonedDateTime.now());
		this.setUpdatedAt(ZonedDateTime.now());
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
