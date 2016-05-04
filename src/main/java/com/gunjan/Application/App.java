package com.gunjan.Application;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.gunjan.doa.MovieDAO;
import com.gunjan.insertion.DataInsertion;
import com.gunjan.model.Actor;
import com.gunjan.model.Director;
import com.gunjan.model.Movie;
import com.gunjan.model.MovieCharacter;
import com.mysql.jdbc.log.Slf4JLogger;

public class App {
	private static Logger logger = Logger.getLogger(App.class);

	

	public static void main(String[] args) throws IOException {
		DataInsertion.insertData();
		
		MovieDAO m = new MovieDAO();
		
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
