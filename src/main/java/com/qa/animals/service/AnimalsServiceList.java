package com.qa.animals.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.animals.domain.Animals;

// controller is going to be dependent on the service class because they talk to each other
// controller will do all the mapping but will have to pass the information through to the service class
// and the service will do all the logic

@Service
public class AnimalsServiceList implements AnimalsInterface {
	
	// Java can't read a table so you will use an Array to represent that until you connect do a db.
		// it will take all of the post requests
		
	private List<Animals> animals = new ArrayList<>();

	@Override
	public Animals create(Animals x) {
		x.setId((long) this.animals.indexOf(x)); // -- update ID variable with an array index
		this.animals.add(x);
		Animals created = this.animals.get(this.animals.size()-1); // -- returns a postman record of what's been created
		return created;
	}

	@Override
	public List<Animals> read() {
		return this.animals;
	}
	
	public Animals readOne(int id) {
		return this.animals.get(id);
	}

	@Override
	public Animals update(int id, Animals y) {
		this.animals.set(id, y);
		return this.animals.get(id); 
	
	}

	@Override
	public Animals delete(int id) {
		return this.animals.remove(id);
	}

}
