package com.qa.animals.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
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
import com.qa.animals.service.AnimalsServiceDB;
import com.qa.animals.service.AnimalsServiceList;

// All CRUD commands go in here

@RestController // will be mapping the requests to metods
public class AnimalsController {
	
	// we need to make this class dependent on service class
//	private AnimalsServiceList service; // CDI - context & dependency injection
	//when making your project you don't need to make AnimalServiceList
	// you go straight to building DB so
	//after creating animal service DB we're changing above to
	
	private AnimalsServiceDB service; //CDI - context & dependency injection
	
	public AnimalsController(AnimalsServiceDB service) {
		super();
		this.service = service;
	}

	//CREATE
	// -- it's a post request so we need post mapping request
	@PostMapping("/create")
	public ResponseEntity<Animals> createAnimal(@RequestBody Animals a) {
		return new ResponseEntity<Animals>(this.service.create(a), HttpStatus.CREATED); //adds a custom response code to postman 
	
	}
	
//	//READ
//	@GetMapping("/readAll")
//	public List<Animals> readAnimal() {
//		return this.service.read();
//	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Animals>> readAnimal() {
//		List<Animals> read = (List<Animals>) this.service.read();
		return new ResponseEntity<List<Animals>>(this.service.read(), HttpStatus.ACCEPTED);
	}
	
	//READ by ID
	@GetMapping("/readById/{id}")
	public ResponseEntity<Animals> getById(@PathVariable Long id) {
		return new ResponseEntity<Animals>(this.service.readOne(id), HttpStatus.FOUND);
	}
	
	//UPDATE (pass an id, find a record at that id, replace with new information, aside from passing the body
				// we also need to pass the id)
	
//	@PutMapping("/update/{id}")
//	public Animals update(@PathVariable int id, @RequestBody Animals updated) {
//		return this.service.update(id, updated);
//	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Animals> update(@PathVariable Long id, @RequestBody Animals updated) {
		return new ResponseEntity<Animals>(this.service.update(id, updated), HttpStatus.I_AM_A_TEAPOT);
	}
	
	
	//DELETE
	@DeleteMapping("/delete")
	public Animals delete(@PathParam("id") Long id) {
		return this.service.delete(id);
	}
	
// 	THIS DOESN'T WORK AND I DON'T KNOW WHY!!!!
//	
//	@PutMapping("/delete") 
//	public ResponseEntity<Animals> delete(@PathParam("id") Long id) {
//		return new ResponseEntity<Animals>(this.service.delete(id), HttpStatus.GONE);
//	}
	
	@DeleteMapping("/remove")
	public boolean remove(@PathParam("id") Long id) {
		return this.service.remove(id);
	}
}
