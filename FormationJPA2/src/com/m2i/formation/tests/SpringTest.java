package com.m2i.formation.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.Media2Repository;
import com.m2i.formation.media.repositories.MediaRepository;
import com.m2i.formation.services.FactorySingleton;
import com.m2i.formation.services.MainService;

public class SpringTest {

	@Test
	public void testMedia() {
		ApplicationContext factory = FactorySingleton.getInstance();
		Media m = (Media) factory.getBean("media");
		assertNotNull(m);
		Media2Repository mr = (Media2Repository)factory.getBean("media2Repository");
		assertNotNull(mr);
		System.out.println(m.getPrice());
		System.out.println(m.getTitle());
		System.out.println(m.getId());
	}
	
	@Test
	public void testMainService() {
		ApplicationContext factory = FactorySingleton.getInstance();
		MainService ms = factory.getBean("mainService",MainService.class);
		assertNotNull(ms);
		System.out.println(ms.getMediaRepository());
	
	}

}
