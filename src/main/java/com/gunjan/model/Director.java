package com.gunjan.model;

import java.util.HashSet;


import javax.persistence.OneToMany;

public class Director extends Person {
	
	@OneToMany(mappedBy= "director")
	public HashSet<Movie> directedMovies = new HashSet<Movie>();
	
	public String getMovies() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addMovie(Movie m){
		directedMovies.add(m);
		if (m.getDirector()== null){
			m.setDirector(this);
		}
	}

	public HashSet<Movie> getDirectedMovies() {
		return directedMovies;
	}

	public void setDirectedMovies(HashSet<Movie> directedMovies) {
		this.directedMovies = directedMovies;
	}
	

}
