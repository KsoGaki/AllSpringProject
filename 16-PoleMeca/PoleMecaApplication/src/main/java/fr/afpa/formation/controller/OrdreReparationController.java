package fr.afpa.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.afpa.formation.dto.OrdreReparationDTO;
import fr.afpa.formation.service.OrdreReparationServiceDTO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/rest/ordrereparation")
public class OrdreReparationController {

	@Autowired
	OrdreReparationServiceDTO ordreReparationServiceDTO;  

	@GetMapping("")
	public List<OrdreReparationDTO> list() {
		List<OrdreReparationDTO> listOrdreReparationDTO = ordreReparationServiceDTO.findAll();
		return listOrdreReparationDTO;
	}

	@GetMapping("/{id}")
	public OrdreReparationDTO findById(@PathVariable("id") long id) throws JsonProcessingException {
		OrdreReparationDTO ordreReparationDTO = ordreReparationServiceDTO.findById(id);
		return ordreReparationDTO;
	}

}
