package com.junit.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.junit.demo.model.Person;
import com.junit.demo.repository.PersonRepository;

@Service
public class PersonService {
   
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAllEmployees()
	{
		/*
		 * Person person=new Person(); person.setPid(1); person.setName("prashant");
		 * person.setCity("Phaltan"); List<Person> ListP=new ArrayList<>();
		 * ListP.add(person); return ListP;
		 */
		return personRepository.findAll();
	}

	public Person createUser(Person model) {
		return personRepository.save(model);
		}

	public boolean deletePerson(int id) {
		Optional<Person> p=personRepository.findById(id);
		if(p.isPresent())
		{
			personRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
