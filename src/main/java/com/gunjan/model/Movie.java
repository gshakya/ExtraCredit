package com.gunjan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue 
	private long id;
	
	
	
	@ManyToMany
	@JoinTable(name = "Movie_Actor", 
			   joinColumns = @JoinColumn(name = "Movie_Id"), 
			   inverseJoinColumns = @JoinColumn(name = "Actor_Id"))
	private Set<Actor> actors = new HashSet<Actor>();
	
		
	@ManyToOne
	@JoinColumn(name= "director_id")
	private Director director;
	
	public Set<Actor> getActors() {

		return actors;
	}

	public void addActor(Actor a) {
		if (!a.getActedMovies().contains(this)) {
			a.addMovie(this);
		}
	}
	
	public void setDirector(Director d){
		director = d;
		if (!d.getDirectedMovies().contains(this)){
			d.addMovie(this);
		}
	}

	public Director getDirector() {
		return director;
	}
	
}
