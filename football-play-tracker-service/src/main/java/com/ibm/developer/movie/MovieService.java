package com.ibm.developer.movie;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

	private MovieRepo repo;

	public MovieService(MovieRepo repo) {
		this.repo = repo;
	}

	public Iterable<Movie> allMovies(){
		return repo.findAll();
	}
	
	public Movie addMovie(Movie movie) {
		//TODO: Implement call to database
		return movie;
	}
	
	
}
