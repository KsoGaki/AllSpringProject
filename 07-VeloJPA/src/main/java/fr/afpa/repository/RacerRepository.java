package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.entity.Racer;

@Component
public interface RacerRepository extends CrudRepository<Racer, Long> {

}
