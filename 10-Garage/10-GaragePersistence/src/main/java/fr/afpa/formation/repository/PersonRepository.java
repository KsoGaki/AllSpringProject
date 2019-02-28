package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.formation.entity.Person;

@Component
public interface PersonRepository extends CrudRepository<Person, Long> {

}
