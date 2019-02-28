package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.entity.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

}
