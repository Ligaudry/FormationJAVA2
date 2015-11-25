package com.m2i.formation.media.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.m2i.formation.media.entities.Media;

public class Media2Repository extends AbstractRepository<Media> {

	public List<Media> getByPrice(double price) {
		return getByJPQL("select e from Media e where e.price <= "+price);
	}

}
