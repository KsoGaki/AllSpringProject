package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.entity.Race;

@Component
public interface RaceRepository extends CrudRepository<Race, Long> {

}
