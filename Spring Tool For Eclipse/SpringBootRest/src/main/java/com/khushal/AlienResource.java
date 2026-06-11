package com.khushal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {
	
	@Autowired
	AlienRepository repo;
	
//	@RequestMapping("aliens") // it will also work
	@GetMapping("aliens") // used for GET request
	public List<Alien> getAliens(){
//		List<Alien> aliens = new ArrayList<>();
		List<Alien> aliens = (List<Alien>) repo.findAll();
		
		
		return aliens;
	}
}
