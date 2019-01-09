package com.ibm.developer.movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "MOVIE_NAME")
	private String movieName;
	@Column(name = "GENRE")
	private String genre;
	@Column(name = "YEAR_RELEASED")
	private int yearReleased;
	@Column(name = "RUNTIME")
	private int runtime;

	public Movie() {
	}

	public Movie(long id, String movieName, String genre, int yearReleased, int runtime) {
		this.id = id;
		this.movieName = movieName;
		this.genre = genre;
		this.yearReleased = yearReleased;
		this.runtime = runtime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

}
