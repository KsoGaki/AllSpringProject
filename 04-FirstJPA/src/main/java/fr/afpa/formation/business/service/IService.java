package fr.afpa.formation.business.service;

import java.util.List;

public interface IService<T,E extends Exception> {
	
	/**
	 * Create an entity
	 * 
	 * @param t - The entity to create
	 * @return  An entity with an id
	 * @throws E Exception  <br>
	 * 			(1.) - EntityNotValidException <br>
	 * 			(2.) - EntityAlreadyExistsException
	 */
	public abstract T create(T t) throws E;

	/**
	 * Find an entity
	 * 
	 * @param id - The id of the entity
	 * @return The entity with the given id
	 * @throws E Exception  <br>
	 * 			(1.) - EntityNotFoundException
	 */
	public abstract T findById(Long id) throws E;

	/**
	 * Find the list of 
	 * 
	 * @return List of entities
	 * @throws E Exception  <br>
	 * 			(1.) - SpecieNotAvailableException
	 */
	public abstract List<T> findAll() throws E;

	/**
	 * Delete an entity in the database
	 * 
	 * @param id - The id of the entity
	 * @return void
	 * @throws E Exception  <br>
	 * 			(1.) - EntityNotFoundException
	 */
	public abstract void deleteById(Long id) throws E;

	/**
	 * Update an entity in the database
	 * 
	 * @param t - The entity to update
	 * @return T - The updated entity
	 * @throws E Exception  <br>
	 * 			(1.) - EntityNotFoundException <br>
	 * 			(2.) - EntityNotValidException
	 */
	public abstract T update(T t) throws E;
}
