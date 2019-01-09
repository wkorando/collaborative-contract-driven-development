package com.ibm.developer.movie;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest(classes = MovieServiceApplication.class)
@RunWith(SpringRunner.class)
public class BaseClass {

	@Autowired
	private MovieController controller;
	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

	@MockBean
	private MovieService service;

	@Before
	public void before() throws Throwable {
		Mockito.when(service.addMovie(any())).thenReturn(new Movie());
		RestAssuredMockMvc.standaloneSetup(this.controller);
	}

}
