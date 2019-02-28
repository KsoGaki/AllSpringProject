package fr.afpa.formation.reposiroty;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.entity.ItemOrder;

public interface ItemOrderRepository extends CrudRepository<ItemOrder, Long>{


}
