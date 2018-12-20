package com.developer.ibm.football.footballplaytrackerservice;

import org.springframework.stereotype.Service;

@Service
public class FootballPlayService {

	private FootballPlayRepo repo;

	public FootballPlayService(FootballPlayRepo repo) {
		this.repo = repo;
	}

	public FootballPlay addFootballPlay(FootballPlay footballPlay) {
		return null;
	}
	
	
}
