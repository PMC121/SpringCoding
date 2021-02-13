package com.junit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringJunitApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringJunitApplication.class, args);
	}
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(SpringJunitApplication.class);
	  }

}
