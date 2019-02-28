package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Client;
import fr.afpa.formation.exception.client.ClientAlreadyExistsException;
import fr.afpa.formation.exception.client.ClientNotAvailableException;
import fr.afpa.formation.exception.client.ClientNotFoundException;
import fr.afpa.formation.exception.client.ClientNotValidException;
import fr.afpa.formation.repository.ClientRepository;

@Service
public class ClientService implements IService<Client, Exception>{

	@Autowired
	ClientRepository postRepository;

	@Override
	public Client create(Client client) throws ClientNotValidException, ClientAlreadyExistsException {
		if(client == null) {
			throw new ClientNotValidException("Client Not Valid Exception");
		}
		if(client.getId() != null && postRepository.existsById(client.getId())) {
			throw new ClientAlreadyExistsException("Client Already Exists Exception");
		}
		postRepository.save(client);
		return client;
	}

	@Override
	public Client findById(Long id) throws ClientNotFoundException {
		Optional<Client> client = postRepository.findById(id);
		if(!client.isPresent()) {
			throw new ClientNotFoundException("Client Not Found Exception");
		}
		return client.get();
	}

	@Override
	public List<Client> findAll() throws ClientNotAvailableException {
		List<Client> listClient = (List<Client>) postRepository.findAll();
		if(listClient == null) {
			throw new ClientNotAvailableException("Client Not Available Exception");
		}
		return listClient;
	}

	@Override
	public void deleteById(Long id) throws ClientNotFoundException {
		if(!postRepository.existsById(id)) {
			throw new ClientNotFoundException("Client Not Found Exception");
		}
		postRepository.deleteById(id);
	}

	@Override
	public Client update(Client client) throws ClientNotValidException, ClientNotFoundException {
		if(client == null) {
			throw new ClientNotValidException("Client Not Valid Exception");
		}
		if(client.getId() == null || !postRepository.existsById(client.getId())) {
			throw new ClientNotFoundException("Client Not Found Exception");
		}
		postRepository.save(client);
		return client;
	}

}
