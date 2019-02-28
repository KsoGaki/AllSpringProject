package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.entity.Bike;

@Component
public interface BikeRepository extends CrudRepository<Bike, Long> {

}
