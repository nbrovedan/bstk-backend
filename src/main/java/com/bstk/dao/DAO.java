package com.bstk.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {
	/**
	 * Método para retornar uma entity
	 * @return EntityManager
	 */
	protected final EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
	    factory = Persistence.createEntityManagerFactory("bstk");
    		return factory.createEntityManager();
	}
}
