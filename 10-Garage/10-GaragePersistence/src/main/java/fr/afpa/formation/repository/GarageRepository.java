package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.formation.entity.Garage;

@Component
public interface GarageRepository extends CrudRepository<Garage, Long> {

}
