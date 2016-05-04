package com.gunjan.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private long movie_id;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Movie_Actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private Set<Actor> actors = new HashSet<Actor>();

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "director_id")
	private Director director;
	private String title;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] poster;
	@Enumerated (EnumType.STRING)
	private MovieGenre genre;
	
	@Enumerated(EnumType.STRING)
	private MovieRating rating;
	
	private String summary;
	private int year;
	
	

	public Set<Actor> getActors() {

		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public void addActor(Actor a) {
		actors.add(a);
		if(!a.getActedMovies().contains(this))
			a.addMovie(this);
		}

	public void setDirector(Director d) {
		director = d;
		d.addMovie(this);

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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "================\nMovie: " + title + "\nDirector=" + director.getName() +  "\nSummary=" + summary + "\nYear=" + year +"\nActors:"+actors.stream().map(actor-> actor.toString()).collect(Collectors.joining(", "));
	}

	public MovieGenre getGenre() {
		return genre;
	}

	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}

	public MovieRating getRating() {
		return rating;
	}

	public void setRating(MovieRating rating) {
		this.rating = rating;
	}
	
	
	
}
