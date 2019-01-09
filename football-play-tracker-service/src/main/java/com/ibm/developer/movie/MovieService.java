package com.ibm.developer.movie;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

	private MovieRepo repo;

	public MovieService(MovieRepo repo) {
		this.repo = repo;
	}

	public Movie addMovie(Movie movie) {
		return null;
	}
	
	
}
