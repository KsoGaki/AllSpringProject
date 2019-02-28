package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.afpa.entity.Category;

@Component
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
