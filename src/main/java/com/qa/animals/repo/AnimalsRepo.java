package com.qa.animals.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.animals.domain.Animals;

// JpaRepository allows us to save, read etc from database

@Repository
public interface AnimalsRepo extends JpaRepository<Animals, Long>{
	
// you can create custom queries in here by using abstract methods	

}
