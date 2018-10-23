package com.builder;

import enterprise.Film;
// this class is used to achieve BUILDER DESIGN PATTERN
public class FilmBuilder {
// same fields as the Film Class
	private long filmId;
    private int  filmYear,filmGross;
	private String filmName,filmCredits,filmGenre,filmCountry ="";
	
	
	public FilmBuilder() {
	}
	// setters for all the fields
	public FilmBuilder setFilmId(long filmId) {
		this.filmId = filmId;
		return this;
	}
	public FilmBuilder setFilmYear(int filmYear) {
		this.filmYear = filmYear;
		return this;
	}
	public FilmBuilder setFilmGross(int filmGross) {
		this.filmGross = filmGross;
		return this;
	}
	public FilmBuilder setFilmName(String filmName) {
		this.filmName = filmName;
		return this;
	}
	public FilmBuilder setFilmCredits(String filmCredits) {
		this.filmCredits = filmCredits;
		return this;
	}
	public FilmBuilder setFilmGenre(String filmGenre) {
		this.filmGenre = filmGenre;
		return this;
	}
	public FilmBuilder setFilmCountry(String filmCountry) {
		this.filmCountry = filmCountry;
		return this;
	}
	// this will return the new Film class and will be passed to the film object
	//this is how i achieved BUILDER DESIGN PATTERN
	public Film getFilmValues() {
		return new Film(filmId, filmYear, filmGross, filmName, filmCredits, filmGenre, filmCountry);
	}
	
}
