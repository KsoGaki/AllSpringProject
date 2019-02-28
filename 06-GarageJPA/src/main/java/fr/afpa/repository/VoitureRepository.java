package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.entity.Voiture;

public interface VoitureRepository extends CrudRepository<Voiture, Long> {

}
