package com.khushal;

import org.springframework.data.repository.CrudRepository;

// CrudRepository<Alien, Integer>  Primary Key Type is Integer
public interface AlienRepository extends CrudRepository<Alien, Integer> 
{
	
}
