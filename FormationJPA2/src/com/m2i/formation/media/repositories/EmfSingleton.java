package com.m2i.formation.media.repositories;

import javax.persistence.*;

public class EmfSingleton {
	private static EntityManagerFactory instance;

	private EmfSingleton() {
	};

	public static synchronized EntityManagerFactory getInstance() {
		if (instance == null) {
			instance = Persistence.createEntityManagerFactory("FormationJPA2");
		}

		return instance;

	}

}
