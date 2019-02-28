package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long>{


}
