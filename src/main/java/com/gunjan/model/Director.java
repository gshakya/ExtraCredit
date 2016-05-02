package com.gunjan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Director")
public class Director extends Person {
	
	@OneToMany(mappedBy= "director")
	public Set<Movie> directedMovies = new HashSet<Movie>();
	
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

	public Set<Movie> getDirectedMovies() {
		return directedMovies;
	}

	public void setDirectedMovies(HashSet<Movie> directedMovies) {
		this.directedMovies = directedMovies;
	}
	

}
