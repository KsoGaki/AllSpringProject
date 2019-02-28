package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.entity.Box;

public interface BoxRepository extends CrudRepository<Box, Long> {

}
