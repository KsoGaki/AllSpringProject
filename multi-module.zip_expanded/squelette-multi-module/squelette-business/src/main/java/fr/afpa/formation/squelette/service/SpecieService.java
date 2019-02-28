package fr.afpa.formation.squelette.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.squelette.dao.SpecieRepository;
import fr.afpa.formation.squelette.persistence.Specie;

@Service
@Transactional
public class SpecieService {
	@Autowired
	SpecieRepository repo;
	
	public List<Specie> list() {
		return (List<Specie>)repo.findAll();
	}
}
