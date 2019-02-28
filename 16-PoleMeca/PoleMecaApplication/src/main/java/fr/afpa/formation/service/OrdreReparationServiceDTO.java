package fr.afpa.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.dto.OrdreReparationDTO;
import fr.afpa.formation.entity.OrdreReparation;

@Service
public class OrdreReparationServiceDTO {

	@Autowired
	OrdreReparationService ordreReparationService;

	public OrdreReparationDTO findById(Long id) {
		OrdreReparationDTO ordreReparationDTO = new OrdreReparationDTO(ordreReparationService.findById(id));
		return ordreReparationDTO;
	}

	public List<OrdreReparationDTO> findAll() {
		List<OrdreReparation> listOrdreReparation = (List<OrdreReparation>) ordreReparationService.findAll();
		List<OrdreReparationDTO> listOrdreReparationDTO = new ArrayList<OrdreReparationDTO>();
		for (OrdreReparation ordreReparation : listOrdreReparation) {
			listOrdreReparationDTO.add(new OrdreReparationDTO(ordreReparation));
		}
		return listOrdreReparationDTO;
	}
}
