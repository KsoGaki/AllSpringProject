package fr.afpa.formation.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.afpa.formation.persistence.entity.Animal;

@Component
@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

}
