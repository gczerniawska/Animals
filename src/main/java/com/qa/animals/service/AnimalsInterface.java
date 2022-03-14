package com.qa.animals.service;

import java.util.List;

import com.qa.animals.domain.Animals;

// creating this interface so later on when you connect to a db you don't have to change the code in your class
// you can just create a new class and inherit from this interface

public interface AnimalsInterface<T> {
// service class will carry out the same methods CRUD methods as before so you will need these abstract methods
// for each of the CRUD 

	Animals create(Animals x);
	
	List<Animals> read();
	
	Animals update(T id, Animals y);
	
	Animals delete(T id);

}
