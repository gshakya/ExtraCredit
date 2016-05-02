package com.gunjan.model;

import java.util.HashSet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Actor")
public class Actor extends Person {
	
	@ManyToMany(mappedBy = "Actors")
	private HashSet<Movie> actedMovies= new HashSet<Movie>();
	
	public void addMovie(Movie m){
		actedMovies.add(m);
		
		if(!m.getActors().contains(this)){
			m.addActor(this);
		}
	}

	public HashSet<Movie> getActedMovies() {
		return actedMovies;
	}
	
	
}
