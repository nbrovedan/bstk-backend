package com.bstk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ValidationException;

import com.bstk.models.Pessoa;

public class PessoaDAO extends DAO {
	
	/**
	 * Salvar pessoa
	 * @param pessoa
	 */
	public void save(Pessoa pessoa) throws ValidationException{
		//Pega um entity
		EntityManager em = getEntityManager();
		//salva um novo caso não exista ou atualiza
		try {
			em.getTransaction().begin();
			if(pessoa.getId() == 0) {
				em.persist(pessoa);
			}else {
				em.merge(pessoa);
			}
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas(){
		EntityManager em = getEntityManager();
		try {
			return em.createQuery("from Pessoa").getResultList();
		} finally {
			em.close();
		}
		
	}
	
	public Pessoa getPessoa(int id){
		EntityManager em = getEntityManager();
		try {
			return em.find(Pessoa.class, id);
		} finally {
			em.close();
		}
	}
	
	public void remove(int id) {
		EntityManager em = getEntityManager();
		try {
			Pessoa pessoa = em.find(Pessoa.class, id);
			em.getTransaction().begin();
			em.remove(pessoa);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
