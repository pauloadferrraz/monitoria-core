package br.unb.cic.monitoria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private HibernateUtil() {	}

	private static HibernateUtil instance;

	public static HibernateUtil instance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}

	public EntityManager em() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		return factory.createEntityManager();
	}
}
