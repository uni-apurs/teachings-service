package com.apurs.microservices.teachingsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apurs.microservices.teachingsservice.model.Teaching;

@Repository
public interface TeachingRepository extends JpaRepository<Teaching, Integer> {
	List<Teaching> findByCourseId(Integer courseId);
	List<Teaching> findByProfessorId(Integer professorId);
}
