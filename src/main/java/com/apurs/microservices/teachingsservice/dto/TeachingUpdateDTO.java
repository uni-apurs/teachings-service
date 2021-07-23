package com.apurs.microservices.teachingsservice.dto;

import java.time.ZonedDateTime;

public class TeachingUpdateDTO {
	private int id;
	private int courseId;
	private int professorId;
	private ZonedDateTime updatedAt;
	
	public TeachingUpdateDTO(int id, int courseId, int professorId, ZonedDateTime updatedAt) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.professorId = professorId;
		this.setUpdatedAt(ZonedDateTime.now());
	}

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

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
