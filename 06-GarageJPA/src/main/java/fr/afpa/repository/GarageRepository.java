package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.entity.Garage;

public interface GarageRepository extends CrudRepository<Garage, Long> {

}
