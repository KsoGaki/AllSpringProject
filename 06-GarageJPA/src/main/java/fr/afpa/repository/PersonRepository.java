package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
