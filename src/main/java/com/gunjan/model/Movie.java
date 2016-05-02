package com.gunjan.model;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	@ManyToMany
	@JoinTable(name = "Movie_Actor", 
			   joinColumns = @JoinColumn(name = "Movie_Id"), 
			   inverseJoinColumns = @JoinColumn(name = "Actor_Id"))
	private HashSet<Actor> actors = new HashSet<Actor>();
	@ManyToOne
	private Director director;
	
	public HashSet<Actor> getActors() {

		return actors;
	}

	public void addActor(Actor a) {
		if (!a.getActedMovies().contains(this)) {
			a.addMovie(this);
		}
	}
	
	public void set

}
