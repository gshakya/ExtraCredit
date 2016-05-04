package com.gunjan.connUtil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBConnectionSession {
	
	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("lmdb");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
//	public static final SessionFactory sessionFactory;
//	static {
//		try {
//			Configuration configuration = new Configuration();
//			configuration.configure();
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//					.applySettings(configuration.getProperties()).build();
//			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//		} catch (Throwable ex) {
//			System.err.println("Initial Session Factory Creation failed ");
//			throw new ExceptionInInitializerError(ex);
//		}
//	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
