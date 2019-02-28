package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.afpa.entity.Item;

@Component
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
