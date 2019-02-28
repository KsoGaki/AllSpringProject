package fr.afpa.formation.repository;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.formation.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{


}
