package com.gunjan.doa;

import java.util.List;

import com.gunjan.model.Movie;
import com.gunjan.model.MovieGenre;
import com.gunjan.model.MovieRating;

public interface IMovieDAO {
	
	public List<Movie> getMovieByTitle(String title);
	public List<Movie> getMovieByYear(int year);
	public List<Movie> getMovieByGenre(MovieGenre genre);
	public List<Movie> getMovieByRating(MovieRating rating);
	public void removeMovie(Long id);
	

}
