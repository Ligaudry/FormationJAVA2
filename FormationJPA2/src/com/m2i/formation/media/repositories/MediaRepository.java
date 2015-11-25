package com.m2i.formation.media.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.m2i.formation.media.entities.Media;

public class MediaRepository implements IRepository<Media>, IUoW {

//	private EntityManagerFactory emf =  EmfSingleton.getInstance();s//sera instancié dans le test (ou qd on créera un nvl objet de la classe)
//	private EntityManager em = emf.createEntityManager();//sera instancié dans le test (ou qd on créera un nvl objet de la classe)
//	private EntityTransaction transaction = em.getTransaction();//sera instancié dans le test (ou qd on créera un nvl objet de la classe)
	
	private EntityManager em;
	private EntityTransaction transaction;
	
	@Override
	public EntityTransaction getTransaction() {
		return this.transaction;
	}

	@Override
	public void setTransaction(EntityTransaction transaction) {
		this.transaction = transaction;

	}

	@Override
	public void commit() {
		this.transaction.commit();

	}

	@Override
	public EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public Media save(Media m) {
		em.persist(m);
		return m;
	}

	@Override
	public Media update(Media m) {//normalement il n'y aurait pas de update à faire, 
									//on le fait dans le cas où l'objet n'a pas téét 
									//créé par le même entityManager
		return em.merge(m);
	}

	@Override
	public void remove(Media m) {
		em.remove(m);
	}

	@Override
	public Media getById(int id) {
		Media m = em.find(Media.class, id);
		return m;
	}

	@Override
	public List<Media> getAll() {
		Query q = em.createQuery("select m.title from Media m");
		List<Media> listMedia = q.getResultList();
		return listMedia;
	}

}
