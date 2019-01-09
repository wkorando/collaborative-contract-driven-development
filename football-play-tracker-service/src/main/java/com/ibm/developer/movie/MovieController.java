package com.ibm.developer.movie;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/movies")
public class MovieController {

	private MovieRepo repo;
	private MovieService service;

	@GetMapping
	public ResponseEntity<Iterable<Movie>> findAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> findOne(long id) {
		Optional<Movie> footballPlay = repo.findById(id);
		if (footballPlay.isPresent()) {
			return ResponseEntity.ok(footballPlay.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Movie> addMovie(@RequestBody Movie footballPlay) {
		return ResponseEntity.ok(service.addMovie(footballPlay));
	}

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<String[]> handleClientError(ClientException ex) {
		return ResponseEntity.badRequest().body(ex.getErrorMessages());
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<String[]> handleServiceError(ServiceException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getErrorMessages());
	}
}
