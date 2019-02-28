package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.afpa.entity.Warranty;

@Component
@Repository
public interface WarrantyRepository extends CrudRepository<Warranty, Long> {

}
