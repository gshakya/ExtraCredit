package com.gunjan.model;

import java.util.Date;
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
	private String title;
	private byte[] poster;
	private String summary;
	private Date year;
	
	
	
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}
	
	
}
