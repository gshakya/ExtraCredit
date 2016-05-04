package com.gunjan.Application;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.gunjan.doa.MovieDAO;
import com.gunjan.insertion.DataInsertion;
import com.gunjan.model.Movie;

public class App {
	private static Logger logger = Logger.getLogger(App.class);

	

	public static void main(String[] args) throws IOException {
		DataInsertion.insertData();
		
		MovieDAO m = new MovieDAO();
		
		m.removeMovie(23L);
		
		for(Movie mov: m.getMovieByTitle("Batman V Superman")){
			System.out.println(mov);
		}
		
		for(Movie mov: m.getMovieByYear(2015)){
			System.out.println(mov);
		}
		
		for(Movie mov: m.getMovieByYear(2015)){
			System.out.println(mov);
		}
		
	}
	
}
