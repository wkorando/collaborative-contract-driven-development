package com.developer.ibm.football.footballplaytrackerservice;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/footballplays")
public class FootballPlayController {

	private FootballPlayRepo repo;
	private FootballPlayService service;

	@GetMapping
	public ResponseEntity<Iterable<FootballPlay>> findAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FootballPlay> findOne(long id) {
		Optional<FootballPlay> footballPlay = repo.findById(id);
		if (footballPlay.isPresent()) {
			return ResponseEntity.ok(footballPlay.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<FootballPlay> addFootballPlay(@RequestBody FootballPlay footballPlay) {
		return ResponseEntity.ok(service.addFootballPlay(footballPlay));
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
