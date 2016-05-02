package com.gunjan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Actor")
public class Actor extends Person {
	
	@ManyToMany(mappedBy = "actors")
	private Set<Movie> actedMovies= new HashSet<Movie>();
	
	public void addMovie(Movie m){
		actedMovies.add(m);
		
		if(!m.getActors().contains(this)){
			m.addActor(this);
		}
	}

	public Set<Movie> getActedMovies() {
		return actedMovies;
	}
	
	
}
