package fr.afpa.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.formation.entity.Specie;
import fr.afpa.formation.service.SpecieService;

@RestController
@RequestMapping("/rest/species")
public class SpecieController {

	@Autowired
	SpecieService specieService;

	@GetMapping("")
	public List<Specie> list() {
		List<Specie> listSpecie = specieService.findAll();
		return listSpecie;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		specieService.deleteById(id);
	}

	@PostMapping("")
	public long create(@RequestBody Specie specie) { 
		return specie.getId();
	}

}
