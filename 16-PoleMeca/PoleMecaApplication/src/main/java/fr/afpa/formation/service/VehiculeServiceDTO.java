package fr.afpa.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.dto.VehiculeDTO;
import fr.afpa.formation.entity.Vehicule;
	
@Service
public class VehiculeServiceDTO{

	@Autowired
	VehiculeService vehiculeService;

	public VehiculeDTO findById(Long id) {
		VehiculeDTO ordreReparationDTO = new VehiculeDTO(vehiculeService.findById(id));
		return ordreReparationDTO;
	}

	public List<VehiculeDTO> findAll() {
		List<Vehicule> listVehicule = (List<Vehicule>) vehiculeService.findAll();
		List<VehiculeDTO> listVehiculeDTO = new ArrayList<VehiculeDTO>();
		for (Vehicule vehicule : listVehicule) {
			listVehiculeDTO.add(new VehiculeDTO(vehicule));
		}
		return listVehiculeDTO;
	}

}
