package fr.afpa.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.dto.ClientDTO;
import fr.afpa.formation.entity.Client;

@Service
public class ClientServiceDTO {

	@Autowired
	ClientService clientService;

	public ClientDTO findById(Long id) {
		ClientDTO clientDTO = new ClientDTO(clientService.findById(id));
		return clientDTO;
	}

	public List<ClientDTO> findAll() {
		List<Client> listClient = (List<Client>) clientService.findAll();
		List<ClientDTO> listClientDTO = new ArrayList<ClientDTO>();
		for (Client client : listClient) {
			listClientDTO.add(new ClientDTO(client));
		}
		return listClientDTO;
	}

}
