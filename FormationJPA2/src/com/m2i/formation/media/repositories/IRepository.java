package com.m2i.formation.media.repositories;

import java.util.List;

import com.m2i.formation.media.entities.IEntity;

public interface IRepository<T>{
	
	public abstract T save(T entity);
	
	public abstract T update(T entity);
	
	public abstract void remove(T entity);
	
	public abstract T getById(int id);
	
	public abstract List<T> getAll();

}
