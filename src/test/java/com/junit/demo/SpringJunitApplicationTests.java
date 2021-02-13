package com.junit.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.demo.model.Person;

                  
@RunWith(SpringRunner.class)
@SuiteClasses(com.junit.demo.Test.class)
@SpringBootTest
public class SpringJunitApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}
	
	@Test 
	public void addPersonTest() throws Exception {
		
		Person person=new Person();
		person.setName("prashant");
		person.setCity("Phaltan");
		
		String JsonReq=new ObjectMapper().writeValueAsString(person);
		MvcResult mvcResult=mockMvc.perform(
                  post("/Persons/addUser").content(JsonReq).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
	       String responseBody = mvcResult.getResponse().getContentAsString();
	    Person responseDto=new ObjectMapper().readValue(responseBody, Person.class);
		Assert.assertTrue(mvcResult.getResponse().getStatus()==200);
		}
	
	@Test
	public void deleteUser() throws Exception
	{
		 MvcResult mvcResult=mockMvc.perform(delete("/Persons/deleteUser/3"))
				 .andExpect(status().isOk())
				 .andReturn();
		 String responseBody = mvcResult.getResponse().getContentAsString();
		 System.out.println("helooooooooooooooooo"+responseBody);
		 Assert.assertTrue(responseBody.equalsIgnoreCase("true"));
	}

	@Test
	public void getAllUsers() throws Exception
	{
		MvcResult mvcResult=mockMvc.perform(get("/Persons/"))
				.andExpect(status().isOk())
				.andReturn();
		
		List<Person> List1= new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Person>>(){});
		 Assert.assertTrue(List1.size()>0);   
	}
}
