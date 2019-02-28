package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
