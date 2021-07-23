package com.apurs.microservices.teachingsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apurs.microservices.teachingsservice.dto.TeachingCreateDTO;
import com.apurs.microservices.teachingsservice.dto.TeachingDTO;
import com.apurs.microservices.teachingsservice.dto.TeachingUpdateDTO;
import com.apurs.microservices.teachingsservice.model.Teaching;
import com.apurs.microservices.teachingsservice.repository.TeachingRepository;

@Service
public class TeachingServiceImpl implements TeachingService{

	private TeachingRepository teachingRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	private ModelMapper modelMapper = new ModelMapper();

	@Value("${app.coursesEndpoint}")
	private String coursesEndpoint;
	
	@Value("${app.professorsEndpoint}")
	private String professorsEndpoint;
	
	public TeachingServiceImpl(TeachingRepository teachingRepository) {
		this.teachingRepository = teachingRepository;
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Override
	public List<TeachingDTO> findAll() {
		List<Teaching> teachings = teachingRepository.findAll();
		List<TeachingDTO> dtos = new ArrayList<TeachingDTO>();
		
		for (Teaching teaching : teachings)
			dtos.add(modelMapper.map(teaching, TeachingDTO.class));
		
		return dtos;
	}

	@Override
	public TeachingDTO findOne(Integer id) {
		Teaching teaching = teachingRepository.getById(id);
		return modelMapper.map(teaching, TeachingDTO.class);
	}

	@Override
	public TeachingDTO insert(TeachingCreateDTO teaching) throws Exception {
		ResponseEntity<String> resCourse = restTemplate.getForEntity(coursesEndpoint + teaching.getCourseId(), String.class);
		ResponseEntity<String> resProfessor = restTemplate.getForEntity(professorsEndpoint + teaching.getProfessorId(), String.class);
		
		if (!resCourse.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid courseId.");
		
		if (!resProfessor.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid professorId.");
			
		Teaching createTeaching = modelMapper.map(teaching, Teaching.class);
		createTeaching = teachingRepository.save(createTeaching);
		return modelMapper.map(createTeaching, TeachingDTO.class);
	}

	@Override
	public TeachingDTO update(TeachingUpdateDTO teaching) throws Exception {
		if (!teachingRepository.existsById(teaching.getId()))
			return null;

		ResponseEntity<String> resCourse = restTemplate.getForEntity(coursesEndpoint + teaching.getCourseId(), String.class);
		ResponseEntity<String> resProfessor = restTemplate.getForEntity(professorsEndpoint + teaching.getProfessorId(), String.class);
		
		if (!resCourse.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid courseId.");
		
		if (!resProfessor.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid professorId.");
		
		Teaching tempTeaching = modelMapper.map(teaching, Teaching.class);
		Teaching updatedTeaching = modelMapper.map(teaching, Teaching.class);
		updatedTeaching.setCreatedAt(tempTeaching.getCreatedAt());
		updatedTeaching = teachingRepository.save(updatedTeaching);
		return modelMapper.map(updatedTeaching, TeachingDTO.class);
	}

	@Override
	public boolean delete(Integer id) {
		if (!teachingRepository.existsById(id))
			return false;

		teachingRepository.deleteById(id);
		return true;
	}
}
