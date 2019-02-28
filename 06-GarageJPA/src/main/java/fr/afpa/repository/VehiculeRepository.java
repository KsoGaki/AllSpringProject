package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.entity.Vehicule;

public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

}
