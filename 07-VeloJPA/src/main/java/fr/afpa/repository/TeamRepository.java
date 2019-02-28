package fr.afpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import fr.afpa.entity.Team;

@Component
public interface TeamRepository extends CrudRepository<Team, Long> {

}
