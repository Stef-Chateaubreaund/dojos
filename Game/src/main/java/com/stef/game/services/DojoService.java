package com.stef.game.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stef.game.models.Dojo;
import com.stef.game.repositories.DojoRepo;

@Service
public class DojoService {
	
	//injects repository into service file
	private final DojoRepo dojoRepo;
	
	//constructor connects service to repo
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo>allDojos(){
		return dojoRepo.findAll();
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo>optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}



	}





