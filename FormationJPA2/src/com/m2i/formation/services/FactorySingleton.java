package com.m2i.formation.services;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FactorySingleton {
	
	private static ApplicationContext instance;
	private FactorySingleton(){};
	
	public static synchronized ApplicationContext getInstance(){
		if(instance == null){
			instance = new ClassPathXmlApplicationContext("spring.xml");
		}
		
		return instance;
	}
	
	
	

}
