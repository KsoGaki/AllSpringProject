package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.entity.Place;

@Component
public interface PlaceRepository extends CrudRepository<Place, Long> {

}
