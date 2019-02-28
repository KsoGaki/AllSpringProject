package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.afpa.formation.entity.Person;

@Component
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
