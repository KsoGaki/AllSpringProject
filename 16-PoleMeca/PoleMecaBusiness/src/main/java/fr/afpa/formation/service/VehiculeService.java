package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Vehicule;
import fr.afpa.formation.exception.vehicule.VehiculeAlreadyExistsException;
import fr.afpa.formation.exception.vehicule.VehiculeNotAvailableException;
import fr.afpa.formation.exception.vehicule.VehiculeNotFoundException;
import fr.afpa.formation.exception.vehicule.VehiculeNotValidException;
import fr.afpa.formation.repository.VehiculeRepository;

@Service
public class VehiculeService implements IService<Vehicule, Exception>{

	@Autowired
	VehiculeRepository vehiculeRepository;

	@Override
	public Vehicule create(Vehicule vehicule) throws VehiculeNotValidException, VehiculeAlreadyExistsException {
		if(vehicule == null) {
			throw new VehiculeNotValidException("Vehicule Not Valid Exception");
		}
		if(vehicule.getId() != null && vehiculeRepository.existsById(vehicule.getId())) {
			throw new VehiculeAlreadyExistsException("Vehicule Already Exists Exception");
		}
		vehiculeRepository.save(vehicule);
		return vehicule;
	}

	@Override
	public Vehicule findById(Long id) throws VehiculeNotFoundException {
		Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
		if(!vehicule.isPresent()) {
			throw new VehiculeNotFoundException("Vehicule Not Found Exception");
		}
		return vehicule.get();
	}

	@Override
	public List<Vehicule> findAll() throws VehiculeNotAvailableException {
		List<Vehicule> listVehicule = (List<Vehicule>) vehiculeRepository.findAll();
		if(listVehicule == null) {
			throw new VehiculeNotAvailableException("Vehicule Not Available Exception");
		}
		return listVehicule;
	}

	@Override
	public void deleteById(Long id) throws VehiculeNotFoundException {
		if(!vehiculeRepository.existsById(id)) {
			throw new VehiculeNotFoundException("Vehicule Not Found Exception");
		}
		vehiculeRepository.deleteById(id);
	}

	@Override
	public Vehicule update(Vehicule vehicule) throws VehiculeNotValidException, VehiculeNotFoundException {
		if(vehicule == null) {
			throw new VehiculeNotValidException("Vehicule Not Valid Exception");
		}
		if(vehicule.getId() == null || !vehiculeRepository.existsById(vehicule.getId())) {
			throw new VehiculeNotFoundException("Vehicule Not Found Exception");
		}
		vehiculeRepository.save(vehicule);
		return vehicule;
	}

}
