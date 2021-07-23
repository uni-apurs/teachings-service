package com.apurs.microservices.teachingsservice.dto;

public class TeachingDTO {
	private int id;
	private int courseId;
	private int professorId;
	
	public TeachingDTO() {
		super();
	}

	public TeachingDTO(int id, int courseId, int professorId) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.professorId = professorId;
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
}
