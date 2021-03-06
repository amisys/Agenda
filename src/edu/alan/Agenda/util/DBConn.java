package edu.alan.Agenda.util;

import org.hibernate.service.ServiceRegistry;

import edu.alan.Agenda.model.Contato;
import edu.alan.Agenda.model.Usuario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBConn {
	
	private static SessionFactory sessionFactory;
	
	public DBConn() {
		super();
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			cfg.configure();
			cfg.addAnnotatedClass(Usuario.class);
			cfg.addAnnotatedClass(Contato.class);
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			ServiceRegistry serviceRegistry = registryBuilder.build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public Session createSession() {
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return session;
		
	}
}
