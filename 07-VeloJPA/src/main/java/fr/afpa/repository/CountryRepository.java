package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.entity.Country;

@Component
public interface CountryRepository extends CrudRepository<Country, Long> {

}
