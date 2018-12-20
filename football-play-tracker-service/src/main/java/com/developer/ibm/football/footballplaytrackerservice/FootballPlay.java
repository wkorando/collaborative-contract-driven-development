package com.developer.ibm.football.footballplaytrackerservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOOTBALL_PLAYS")
public class FootballPlay {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "PLAYER_NAME")
	private String playerName;
	@Column(name = "DISTANCE")
	private String distance;
	@Column(name = "SCORE")
	private boolean score;
	@Column(name = "TURNOVER")
	private boolean turnover;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public boolean isScore() {
		return score;
	}

	public void setScore(boolean score) {
		this.score = score;
	}

	public boolean isTurnover() {
		return turnover;
	}

	public void setTurnover(boolean turnover) {
		this.turnover = turnover;
	}

}
