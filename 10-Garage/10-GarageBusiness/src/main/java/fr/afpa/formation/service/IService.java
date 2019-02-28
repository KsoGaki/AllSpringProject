package fr.afpa.formation.service;

import java.util.List;

public interface IService<T, E extends Exception> {

	public T create(T t) throws E;
	
	public T findById(Long id) throws E;
	
	public List<T> findAll() throws E;
	
	public T update(T t) throws E;
	
	public void delete(Long id) throws E;
	
}
