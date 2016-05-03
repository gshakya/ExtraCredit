package com.gunjan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MovieComment {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name ="movie_id")
	private Movie movie;
	
	private String comment;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
