package com.m2i.formation.media.repositories;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbstractRepository<T> implements IRepository<T>, IUoW {

private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	private EntityTransaction transaction;
	
	@Override
	public EntityTransaction getTransaction() {
		if(transaction == null) {
			transaction = entityManager.getTransaction();
		}
		if(!transaction.isActive()) {
			transaction.begin();
		}
		return transaction;
	}

	@Override
	public void setTransaction(EntityTransaction et) {
		this.transaction = et;
	}

	@Override
	public void commit() {
		getTransaction().commit();
	}
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractRepository() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return getEntityManager().createQuery("select e from "+entityClass.getSimpleName()+" e").getResultList();
	}

	@Override
	public T getById(int id) {
		return getEntityManager().find(entityClass, id);
	}

	@Override
	public T update(T entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public T save(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> getByJPQL(String jpql) {
		return getEntityManager().createQuery(jpql).getResultList();
	}
}
