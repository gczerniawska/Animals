package com.qa.animals.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Class responsible for getting the request and and mapping it to the methods
// that we need to do according to that request

// In spring @ annotations are an indicator to create an instance of the class
// Spring creates classes for you
// This class is responsible for getting the request from front end (in this case postman)
// and mapping it to any method within this class 
// Each of the classes will have a single responsibility

@RestController   // -- this class is responsible for acting as a Rest Controller 
public class TestController {
	
	@GetMapping("/test") // -- in postman when you make a get request it will map it to this method
						//-- in the url you will use /test to reach this method 
	public String hello() {
		return "Hello world!";
	}

}
