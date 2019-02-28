package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.formation.entity.Box;

@Component
public interface BoxRepository extends CrudRepository<Box, Long> {

}
