package fr.afpa.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.formation.dto.VehiculeDTO;
import fr.afpa.formation.service.VehiculeServiceDTO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/rest/vehicule")
public class VehiculeController {

	@Autowired
	VehiculeServiceDTO vehiculeServiceDTO;  

	@GetMapping("")
	public List<VehiculeDTO> list() {
		List<VehiculeDTO> listVehiculeDTO = vehiculeServiceDTO.findAll();
		return listVehiculeDTO;
	}

	@GetMapping("/{id}")
	public VehiculeDTO findById(@PathVariable("id") long id) {
		VehiculeDTO vehiculeDTO = vehiculeServiceDTO.findById(id);
		return vehiculeDTO;
	}

}
