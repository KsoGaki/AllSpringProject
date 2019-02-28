package fr.afpa.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.formation.dto.ClientDTO;
import fr.afpa.formation.service.ClientServiceDTO;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/rest/client")
public class ClientController {

	@Autowired
	ClientServiceDTO clientServiceDTO;  

	@GetMapping("")
	public List<ClientDTO> list() {
		List<ClientDTO> listClientDTO = clientServiceDTO.findAll();
		return listClientDTO;
	}

	@GetMapping("/{id}")
	public ClientDTO findById(@PathVariable("id") long id) {
		ClientDTO clientDTO = clientServiceDTO.findById(id);
		return clientDTO;
	}

//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable("id") long id) {
//		clientService.deleteById(id);
//	}
//
//	@PostMapping("")
//	public long create(@RequestBody Client client) { 
//		return client.getId();
//	}

}
