package com.apurs.microservices.teachingsservice.service;

import java.util.List;

import com.apurs.microservices.teachingsservice.dto.TeachingCreateDTO;
import com.apurs.microservices.teachingsservice.dto.TeachingDTO;
import com.apurs.microservices.teachingsservice.dto.TeachingUpdateDTO;

public interface TeachingService {
	public abstract List<TeachingDTO> findAll();
	public abstract TeachingDTO findOne(Integer id);
	public abstract TeachingDTO insert(TeachingCreateDTO teaching) throws Exception;
	public abstract TeachingDTO update(TeachingUpdateDTO teaching) throws Exception;
	public abstract boolean delete(Integer id);
}
