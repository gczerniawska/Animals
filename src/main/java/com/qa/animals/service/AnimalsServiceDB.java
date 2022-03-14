package com.qa.animals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.animals.domain.Animals;
import com.qa.animals.repo.AnimalsRepo;

@Service
public class AnimalsServiceDB implements AnimalsInterface<Long> {
	
	private AnimalsRepo repo;  // injecting dependency
	
	public AnimalsServiceDB(AnimalsRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Animals create(Animals x) {
		return this.repo.save(x);
	}

	@Override
	public List<Animals> read() {
		return this.repo.findAll();
	}
	
	public Animals readOne(Long id) {
		Optional<Animals> optRead = this.repo.findById(id); 
		return optRead.orElse(null); //can put custom message inst of null such as 'wrong id'
	}
	
	// if you wanna create custom search it will be similar to readOne but instead of Long id
	// you could look for String breed etc

	@Override
	public Animals update(Long id, Animals y) {
		Optional<Animals> optAni = this.repo.findById(id);
		Animals found = optAni.get();
		found.setAge(y.getAge());
		found.setBreed(y.getBreed());
		found.setGender(y.getGender());
		return this.repo.save(found);
	}
	
	// return object deleted to confirm info -- gonna display deleted object
	@Override
	public Animals delete(Long id) {
		Optional<Animals> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}
	
	//or you can confirm delete by returning boolean
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
