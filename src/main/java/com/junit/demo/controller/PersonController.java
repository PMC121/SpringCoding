package com.junit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.demo.model.Person;
import com.junit.demo.service.PersonService;

@RestController
@RequestMapping("/Persons")
public class PersonController {
	
	 @Autowired
	  PersonService service;
	 
	  @GetMapping
	    public ResponseEntity<List<Person>> getAllEmployees() {
	        List<Person> list = service.getAllEmployees();
	 
	        return new ResponseEntity<List<Person>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
		@PostMapping(value = "/addUser")
		public ResponseEntity<Person> addUser(@RequestBody Person model)
		{
			 Person person=service.createUser(model);
		     return new ResponseEntity<Person>(person,HttpStatus.OK);
		   
		}
	    
		@DeleteMapping(value="/deleteUser/{id}")
		public ResponseEntity<Boolean> deleteUser(@PathVariable int id)
		{
			boolean flag =service.deletePerson(id);
			return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
		}
}
