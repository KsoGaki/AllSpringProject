package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.formation.entity.Address;

@Component
public interface AddressRepository extends CrudRepository<Address, Long> {

}
