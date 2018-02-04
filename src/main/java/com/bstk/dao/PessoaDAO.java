package com.bstk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import com.bstk.models.Pessoa;

public class PessoaDAO extends DAO {
	
	/**
	 * Salvar pessoa
	 * @param pessoa
	 */
	public void salvar(Pessoa pessoa) {
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
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas(){
		EntityManager em = getEntityManager();
		return em.createQuery("from Pessoa").getResultList();
	}
	
	public Pessoa getPessoa(int id){
		EntityManager em = getEntityManager();
		return em.find(Pessoa.class, id);
	}
	
	public void remover(int id) {
		EntityManager em = getEntityManager();
		Pessoa pessoa = em.find(Pessoa.class, id);
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
	}
}
