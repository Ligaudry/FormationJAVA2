package com.m2i.formation.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import com.m2i.formation.media.entities.Author;
import com.m2i.formation.media.repositories.EmfSingleton;
import com.m2i.formation.media.repositories.Media2Repository;
import com.m2i.formation.services.MainService;
import com.m2i.formation.services.ServiceException;

public class MediaServicesTests {

	@Test
	public void testNewAuthor() throws ServiceException {
		MainService ms = new MainService();
		Media2Repository mediaRepository = new Media2Repository();
		EntityManagerFactory emf = EmfSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		mediaRepository.setEntityManager(em);
		List<Author> listA = mediaRepository.getById(4).getAuthors();
		Author a = listA.get(0);
		int mediaId = 6;
		ms.addAuthorToMedia(a, mediaId);
		assertNotNull(a.getMedias());
		//assertEquals(2,mediaRepository.getById(6).getAuthors().size());
		
	}
	
	@Test
	public void testAuthor() throws ServiceException {
		MainService ms = new MainService();
		Author a = new Author();
		a.setFirstName("Souazic");
		a.setLastName("LeBon");
		int mediaId = 6;
		ms.addAuthorToMedia(a, mediaId);
		assertNotNull(a.getMedias());
		//assertEquals(2,mediaRepository.getById(6).getAuthors().size());
		
	}

}
