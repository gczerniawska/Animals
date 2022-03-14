package com.qa.animals.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// domain is a package that contains classes that are trying to model a table and it's fields

@Entity // marking this class a table for SQL
public class Animals {
	// create table table_name(
	// id int not null auto_increment,
	// breed varchar(255),
	// age int,
	// gender varchar(255),
	// primary key(id);
	
	
	// variables -- columns in the table
	@Id // marks the field below as a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //setting ID as auto increment
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
