package fr.afpa.formation.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.afpa.formation.dto.SpecieDTO;

@Service
public class SpecieService {	

	static final String BASE_URL = "http://10.111.61.31:8080/rest/species";

	public List<SpecieDTO> findAll() {
		RestTemplate restTemplate = new RestTemplate();
		SpecieDTO [] listSpecieDTO = restTemplate.getForObject(BASE_URL, SpecieDTO[].class);
		return Arrays.asList(listSpecieDTO);
	}

	public SpecieDTO findById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		SpecieDTO specieDTO = restTemplate.getForObject(BASE_URL + "/" + id, SpecieDTO.class);
		return specieDTO;
	}
	
	public void create(SpecieDTO specieDTO) {
		
	}
	
	public void deleteById(Long id) {
		
	}
	
	public SpecieDTO update(SpecieDTO specieDTO) {
		return null;
	}
	
}
