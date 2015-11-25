package com.m2i.formation.tests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.EmfSingleton;

public class UnitTest {
	
	

	@Test
	public void test1() {
		EntityManagerFactory emf = EmfSingleton.getInstance();
		assertNotNull(emf);
		EntityManager em = emf.createEntityManager();
		assertNotNull(em);
	}
	
	@Test
	public void mediaEntity(){
		EntityManagerFactory emf = EmfSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		Media m = em.find(Media.class,11);
		String title = m.getTitle();
		assertNotNull(m);
		assertNotNull(title);
		
	}
	
	@Test
	public void testMedia(){
		EntityManagerFactory emf = EmfSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		Query tq = em.createQuery("select count(m) from Media m");
		long c = (long) tq.getSingleResult();
		assertNotNull(tq);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Media m = new Media();
		m.setTitle("Les aventures de jojo");
		m.setPrice(10);
		m.setId_Publisher(1);
		m.setType(0);
		em.persist(m);
		tx.commit();
		Query tq1 = em.createQuery("select count(m) from Media m");
		Assert.assertEquals(c+1, tq1.getSingleResult());
		tx.begin();
		m.setTitle("c'est la vie bouffi");
		em.persist(m);
		tx.commit();
		Query tq2 = em.createQuery("select count(m.title) from Media m where m.price <15");
		Assert.assertEquals((long)4, tq2.getSingleResult());
		tx.begin();
		em.remove(m);
		tx.commit();
		Query tq3 = em.createQuery("select count(m) from Media m");
		Assert.assertEquals(c, tq3.getSingleResult()); 
		
	}
	
	
}
