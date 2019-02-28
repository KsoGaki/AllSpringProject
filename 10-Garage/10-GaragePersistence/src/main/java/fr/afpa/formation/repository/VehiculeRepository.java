package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.formation.entity.Vehicule;

@Component
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

}
