package com.m2i.formation.media.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface IUoW {
	public EntityTransaction getTransaction();
	
	public abstract void setTransaction(EntityTransaction transaction);
	
	public abstract void commit();
	
	public abstract EntityManager getEntityManager(); 
	
	public abstract void setEntityManager(EntityManager em);

}
