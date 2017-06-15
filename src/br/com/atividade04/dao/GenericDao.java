package br.com.atividade04.dao;

import javax.persistence.EntityManager;
import br.com.atividade04.utils.JpaUtil;

public class GenericDao<T> implements Dao<T> {
	//classe que controla a persistencia de qualquer classe
	
	private final Class<T> classe;
	
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade); 
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void atualizar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade); //atualiza
		em.getTransaction().commit();
		em.close();
	}

	
	@Override
	public void remover(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade)); //remove
		em.getTransaction().commit();
		em.close();
	}
	
}