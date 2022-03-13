package com.qa.animals.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.animals.domain.Animals;

// All CRUD commands go in here

@RestController // will be mapping the requests to metods
public class AnimalsController {
	
	// Java can't read a table so you will use an Array to represent that until you connect do a db.
	// it will take all of the post requests
	
	private List<Animals> animals = new ArrayList<>();
	
	//CREATE
	// -- it's a post request so we need post mapping request
	@PostMapping("/create")
	public ResponseEntity<Animals> createAnimal(@RequestBody Animals a) {
		a.setId((long) this.animals.indexOf(a)); // -- update ID variable with an array index
		this.animals.add(a);
		Animals created = this.animals.get(this.animals.size()-1); // -- returns a postman record of what's been created
		return new ResponseEntity<Animals>(created, HttpStatus.CREATED); //adds a custom response code to postman status line
	
	}
	
	//READ
	@GetMapping("/readAll")
	public List<Animals> readAnimal() {
		return this.animals;
	}
	
	//READ by ID
	@GetMapping("/readById/{id}")
	public Animals getById(@PathVariable int id) {
		return this.animals.get(id);
	}
	
	//UPDATE (pass an id, find a record at that id, replace with new information, aside from passing the body
				// we also need to pass the id)
	
	@PutMapping("/update/{id}")
	public Animals update(@PathVariable int id, @RequestBody Animals updated) {
		this.animals.set(id, updated);
		return this.animals.get(id);
	}
	
	//DELETE
	@DeleteMapping("/delete")
	public void delete(@PathParam("id") int id) {
		this.animals.remove(id);
	}
	

}
