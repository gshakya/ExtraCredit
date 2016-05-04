package com.gunjan.insertion;



import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gunjan.connUtil.DBConnectionSession;
import com.gunjan.model.Actor;
import com.gunjan.model.Director;
import com.gunjan.model.Movie;
import com.gunjan.model.MovieCharacter;
import com.gunjan.model.MovieGenre;
import com.gunjan.model.MovieRating;

public class DataInsertion {

	public static void insertData() throws IOException{
		EntityManagerFactory emf = DBConnectionSession.getEntityManagerFactory();
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
//		try{
			em= emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Path p;
			byte[] fileData;
			//BATMAN V SUPERMAN INSERTION
			
			Actor benAff = new Actor();
			benAff.setName("Ben Affleck");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Ben-Affleck.jpg");
			fileData = Files.readAllBytes(p);
			benAff.setPicture(fileData);

			Actor henCavil = new Actor();
			henCavil.setName("Henry Cavill");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Henry-Cavill.jpg");
			fileData = Files.readAllBytes(p);
			henCavil.setPicture(fileData);

			Actor amyAdams = new Actor();
			amyAdams.setName("Amy Adams");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Amy-Adams.jpg");
			fileData = Files.readAllBytes(p);
			amyAdams.setPicture(fileData);
			
			Director zacSnider = new Director();
			zacSnider.setName("Zack Snyder");
			
			
			Movie batmanVSuperman = new Movie();
			batmanVSuperman.setDirector(zacSnider);
			batmanVSuperman.setSummary("Batman v Superman: Dawn of Justice (2016)");
			batmanVSuperman.addActor(amyAdams);
			batmanVSuperman.addActor(henCavil);
			batmanVSuperman.addActor(benAff);
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "movies", "02-Batman-v-Superman.jpg");
			fileData = Files.readAllBytes(p);
			batmanVSuperman.setPoster(fileData);
			batmanVSuperman.setTitle("Batman V Superman");
			batmanVSuperman.setYear(2016);
			
			
			
			MovieCharacter batman = new MovieCharacter();
			batman.setActor(benAff);
			batman.setMovie(batmanVSuperman);
			batman.setName("Batman");
			
			MovieCharacter superman= new MovieCharacter();
			superman.setActor(henCavil);
			superman.setMovie(batmanVSuperman);
			superman.setName("Superman");
			
			MovieCharacter louis= new MovieCharacter();
			louis.setActor(amyAdams);
			louis.setMovie(batmanVSuperman);
			louis.setName("Louis");
			batmanVSuperman.setGenre(MovieGenre.Action);
			batmanVSuperman.setRating(MovieRating.GOOD);
			
			
			////	FANTASTIC FOUR INSERTION
			
			Actor kateMara = new Actor();
			kateMara.setName("Kate Mara");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Kate-Mara.jpg");
			fileData = Files.readAllBytes(p);
			kateMara.setPicture(fileData);

			Actor jamBell = new Actor();
			jamBell.setName("Jamie Bell");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Jamie-Bell.jpg");
			fileData = Files.readAllBytes(p);
			jamBell.setPicture(fileData);

			Actor mBJordan = new Actor();
			mBJordan.setName("Michael B Jordan");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Michael-B-Jordan.jpg");
			fileData = Files.readAllBytes(p);
			mBJordan.setPicture(fileData);
			
			Director joshTrank = new Director();
			joshTrank.setName("Josh Trank");
			
			
			Movie fantastic4 = new Movie();
			fantastic4.setDirector(joshTrank);
			fantastic4.setSummary("Fantastic 4");
			fantastic4.addActor(kateMara);
			fantastic4.addActor(jamBell);
			fantastic4.addActor(mBJordan);
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "movies", "03-Fantastic-four.jpg");
			fileData = Files.readAllBytes(p);
			fantastic4.setPoster(fileData);
			fantastic4.setTitle("Fantastic Four");
			fantastic4.setYear(2015);
			fantastic4.setGenre(MovieGenre.Comedy);
			fantastic4.setRating(MovieRating.Bad);
			
			
			
			MovieCharacter susanStrom = new MovieCharacter();
			susanStrom.setActor(kateMara);
			susanStrom.setMovie(fantastic4);
			susanStrom.setName("Susan Strom");
			
			MovieCharacter thing= new MovieCharacter();
			thing.setActor(jamBell);
			thing.setMovie(fantastic4);
			thing.setName("The thing");
			
			MovieCharacter humanTorch= new MovieCharacter();
			humanTorch.setActor(mBJordan);
			humanTorch.setMovie(fantastic4);
			humanTorch.setName("Human Torch");
			
			//CAPTAIN AMERICA INSERTION
			
			
			Actor chrisEvan = new Actor();
			chrisEvan.setName("Kate Mara");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Chris-Evans.jpg");
			fileData = Files.readAllBytes(p);
			chrisEvan.setPicture(fileData);

			Actor samLJackson = new Actor();
			samLJackson.setName("Samuel L Jackson");
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "actors", "Samuel-L-Jackson.jpg");
			fileData = Files.readAllBytes(p);
			samLJackson.setPicture(fileData);

			Movie captainAmerica = new Movie();
			captainAmerica.setDirector(joshTrank);
			captainAmerica.setSummary("Captain America ");
			captainAmerica.addActor(chrisEvan);
			captainAmerica.addActor(samLJackson);
			captainAmerica.addActor(jamBell);
			p = FileSystems.getDefault().getPath("", "src", "main", "resources", "images", "movies", "01-Captain-America.jpg");
			fileData = Files.readAllBytes(p);
			captainAmerica.setPoster(fileData);
			captainAmerica.setTitle("Captain America");
			captainAmerica.setYear(2015);
			captainAmerica.setGenre(MovieGenre.Horror);
			captainAmerica.setRating(MovieRating.EXCELLENT);
			
			
			MovieCharacter cptAmerica = new MovieCharacter();
			cptAmerica.setActor(chrisEvan);
			cptAmerica.setMovie(captainAmerica);
			cptAmerica.setName("Captain America");
			
			MovieCharacter nicFury= new MovieCharacter();
			nicFury.setActor(samLJackson);
			nicFury.setMovie(captainAmerica);
			nicFury.setName("Nick Fury");
			
			MovieCharacter hulk= new MovieCharacter();
			hulk.setActor(jamBell);
			hulk.setMovie(captainAmerica);
			hulk.setName("Hulk");
			
			

			em.persist(batmanVSuperman);
			em.persist(batman);
			em.persist(superman);
			em.persist(louis);
			
			em.persist(fantastic4);
			em.persist(susanStrom);
			em.persist(thing);
			em.persist(humanTorch);
			
			em.persist(captainAmerica);
			em.persist(cptAmerica);
			em.persist(hulk);
			em.persist(nicFury);
			
			tx.commit();
//		}
//		catch(Exception ex){
//			if (tx != null ) tx.rollback();
//			ex.printStackTrace();			
//		}
	}
}
