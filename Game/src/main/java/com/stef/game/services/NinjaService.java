package com.stef.game.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stef.game.models.Ninja;
import com.stef.game.repositories.NinjaRepo;

@Service
public class NinjaService {
	//// USER////////
	//injects repo into service file
	private final NinjaRepo ninjaRepo;
	
	//constructor connects service to repo
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
//		this.dojoRepo = dojoRepo;
	}
	
	public List<Ninja>allNinjas(){
		return ninjaRepo.findAll();
	}

	public Ninja findNinja(Long id) {
		Optional<Ninja>optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
