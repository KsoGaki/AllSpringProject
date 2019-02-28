package fr.afpa.formation.reposiroty;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{


}
