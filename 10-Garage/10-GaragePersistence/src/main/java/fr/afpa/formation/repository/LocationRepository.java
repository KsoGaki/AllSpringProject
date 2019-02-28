package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.formation.entity.Location;

@Component
public interface LocationRepository extends CrudRepository<Location, Long> {

}
