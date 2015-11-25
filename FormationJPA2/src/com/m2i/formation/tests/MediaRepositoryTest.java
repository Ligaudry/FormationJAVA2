package com.m2i.formation.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Test;

import com.m2i.formation.media.entities.Author;
import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.EmfSingleton;
import com.m2i.formation.media.repositories.MediaRepository;



public class MediaRepositoryTest {

	@Test
	public void testGetById() {
	EntityManagerFactory emf = EmfSingleton.getInstance();
	MediaRepository mr = new MediaRepository();
	EntityManager em = emf.createEntityManager();
	mr.setEntityManager(em);
	Media m = mr.getById(11);
	assertEquals("Bass Culture", m.getTitle());
	}
	
	@Test
	public void testGetAll(){
	EntityManagerFactory emf = EmfSingleton.getInstance();
	MediaRepository mr = new MediaRepository();
	EntityManager em = emf.createEntityManager();
	mr.setEntityManager(em);
	List<Media> medias = mr.getAll();
	Assert.assertEquals(5, medias.size());	
	}
	
	@Test
	public void testAuthor(){
	EntityManagerFactory emf = EmfSingleton.getInstance();
	MediaRepository mr = new MediaRepository();
	EntityManager em = emf.createEntityManager();
	mr.setEntityManager(em);
	List<Author> auteurs = mr.getById(11).getAuthors();
	String name = auteurs.get(0).getFirstName();
	assertEquals("Linton", name);
	}
	

//	@Test
//	public void testRemove(){
//	MediaRepository mr = new MediaRepository();
//	mr.remove(m);
//	Assert.assertNull(m);
//	}
	
	

	
	

}
