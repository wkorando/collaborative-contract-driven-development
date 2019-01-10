package com.ibm.developer.movie;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
	@MockBean
	private MovieRepo repo;
	@Rule
	public TestName testName = new TestName();

	@Before
	public void before() throws Throwable {
		when(service.addMovie(any(Movie.class))).thenReturn(new Movie(1L, "Default", "Default", 1990, 100));
		
		Movie independenceDay = new Movie(1L, "Independence Day", "Action", 1996, 145);
		List<Movie> movies = new ArrayList<>();
		movies.add(independenceDay);
		when(repo.findAll()).thenReturn(movies);
		RestAssuredMockMvc.standaloneSetup(MockMvcBuilders.standaloneSetup(this.controller)
				.apply(documentationConfiguration(this.restDocumentation))
				.alwaysDo(document(getClass().getSimpleName() + "_" + testName.getMethodName())));
		
		//RestAssuredMockMvc.standaloneSetup(this.controller);
	}

}
