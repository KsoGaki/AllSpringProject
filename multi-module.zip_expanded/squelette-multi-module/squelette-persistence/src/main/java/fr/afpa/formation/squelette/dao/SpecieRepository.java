package fr.afpa.formation.squelette.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.squelette.persistence.Specie;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface SpecieRepository extends CrudRepository<Specie, Long> {
}
