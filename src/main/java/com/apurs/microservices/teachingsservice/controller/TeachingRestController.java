package com.apurs.microservices.teachingsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apurs.microservices.teachingsservice.dto.TeachingCreateDTO;
import com.apurs.microservices.teachingsservice.dto.TeachingDTO;
import com.apurs.microservices.teachingsservice.dto.TeachingUpdateDTO;
import com.apurs.microservices.teachingsservice.service.TeachingService;

@RestController
@RequestMapping("/teachings")
public class TeachingRestController {
	
	@Autowired
	private TeachingService teachingService;
	
	@GetMapping("")
	public List<TeachingDTO> getTeaches(){
		return teachingService.findAll();
	}
	
	@GetMapping("/{id}")
	public TeachingDTO getOne(@PathVariable("id") Integer id) {
		return teachingService.findOne(id);
	}
	
	@PostMapping("")
	public ResponseEntity<TeachingDTO> insertTeaching(@RequestBody TeachingCreateDTO teaching) throws Exception {
		if(teachingService.insert(teaching) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("")
	public ResponseEntity<TeachingDTO> updateTeaching(@RequestBody TeachingUpdateDTO teaching) throws Exception {
		if (teachingService.update(teaching) != null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TeachingDTO> deleteTeaching(@PathVariable("id") Integer id){
		if (teachingService.delete(id))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
