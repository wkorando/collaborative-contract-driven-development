package com.ibm.developer.movie;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
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
	@MockBean
	private MovieRepo repo;

	@Before
	public void before() throws Throwable {
		when(service.addMovie(any(Movie.class))).then(new Answer<Movie>() {
			public Movie answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				Movie movie = (Movie) args[0];
				movie.setId(1);
				return movie;
			}
		});
		
		Movie independenceDay = new Movie(1L, "Independence Day", "Action", 1996, 145);
		List<Movie> movies = new ArrayList<>();
		movies.add(independenceDay);
		when(repo.findAll()).thenReturn(movies);
		RestAssuredMockMvc.standaloneSetup(this.controller);
	}

}
