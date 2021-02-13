package com.junit.demo;

import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {

	@org.junit.Test
	public void display()
	{
		Assert.assertEquals(1, 1);
	}
}
