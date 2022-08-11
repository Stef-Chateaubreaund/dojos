package com.stef.game.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stef.game.models.Dojo;
	
	
@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{

		List<Dojo> findAll();
		
		Optional<Dojo> findById(Long id); 
		
		void deleteById(Long id);
		
	
	}


