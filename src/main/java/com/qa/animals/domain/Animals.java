package com.qa.animals.domain;

// domain is a package that contains classes that are trying to model a table and it's fields

public class Animals {
	
	// variables -- columns in the table
	
	private Long id;
	private String breed;
	private int age;
	private String gender;
	
	// constructors - 3 types
	// overloading - polymorphism
	
	// -- default constructor (empty one, one you don't define, it's given by java)
	
	public Animals() {
		super();
	}

	// -- constructor with ID - for when you want to retrieve and entry by using ID for example
	
	public Animals(Long id, String breed, int age, String gender) {
		super();
		this.id = id;
		this.breed = breed;
		this.age = age;
		this.gender = gender;
	}
	
	// -- constructor without ID - for when you create an entry, ID is on auto increment so it's auto defined
	
	public Animals(String breed, int age, String gender) {
		super();
		this.breed = breed;
		this.age = age;
		this.gender = gender;
	}

	// getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
