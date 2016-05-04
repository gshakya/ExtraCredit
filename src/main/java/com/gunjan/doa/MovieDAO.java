package com.gunjan.doa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.gunjan.connUtil.DBConnectionSession;
import com.gunjan.model.Movie;
import com.gunjan.model.MovieGenre;
import com.gunjan.model.MovieRating;

public class MovieDAO implements IMovieDAO{
	private static EntityManagerFactory emf ; 
	private static EntityManager em;
	private static EntityTransaction tx;
	private Query query;
	
	static {
		emf = DBConnectionSession.getEntityManagerFactory();
		em= emf.createEntityManager();
	}
	
	
	@Override
	public List<Movie> getMovieByTitle(String title) {
		query = em.createQuery("select m from Movie m where m.title = :title ");
		query.setParameter("title", title);
		return query.getResultList();
	}

	@Override
	public List<Movie> getMovieByYear(int year) {
		query = em.createQuery("select m from Movie m where m.year = :year ");
		query.setParameter("year", year);
		return query.getResultList();
	}

	@Override
	public List<Movie> getMovieByGenre(MovieGenre genre) {
		query = em.createQuery("select m from Movie m where m.genre = :genre ");
		query.setParameter("genre", genre);
		return query.getResultList();
	}

	@Override
	public List<Movie> getMovieByRating(MovieRating rating) {
		query = em.createQuery("select m from Movie m where m.rating = :rating ");
		query.setParameter("rating", rating);
		return query.getResultList();
	}

	@Override
	public void removeMovie(Long id) {
		Movie m = em.find(Movie.class,id);
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		
	}
	
	

}
