package fr.afpa.formation.reposiroty;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{


}
