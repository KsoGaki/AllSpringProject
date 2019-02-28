package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.entity.Voiture;

public interface VoitureRepository extends CrudRepository<Voiture, Long> {

}
