package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.afpa.entity.Image;

@Component
@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

}
