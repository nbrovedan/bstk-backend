package com.bstk.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {
	/**
	 * Método para retornar uma entity
	 * @return EntityManager
	 */
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("bstk");
	
	protected final EntityManager getEntityManager() {
    		return factory.createEntityManager();
	}
}
