package com.gunjan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MovieCharacter {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name= "Actor_Id")
	private Actor actor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	
	
	
	
	
	
}
