package fr.afpa.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Voiture;
import fr.afpa.formation.exception.VoitureAlreadyExistsException;
import fr.afpa.formation.exception.VoitureNotAvailableException;
import fr.afpa.formation.exception.VoitureNotFoundException;
import fr.afpa.formation.exception.VoitureNotValidException;
import fr.afpa.formation.exception.VoitureNullException;
import fr.afpa.formation.repository.VoitureRepository;

@Service
public class VoitureService implements IService<Voiture, Exception>{

	@Autowired
	VoitureRepository voitureRepository;

	@Override
	public Voiture create(Voiture voiture) throws Exception {
		if(voiture == null) {
			throw new VoitureNullException("Voiture Null Exception");
		}
		if(voiture.getId() != null || voitureRepository.existsById(voiture.getId())) {
			throw new VoitureAlreadyExistsException("Voiture Already Exists Exception");
		}
		return voitureRepository.save(voiture);
	}

	@Override
	public Voiture findById(Long id) throws Exception {
		if(id == null || !voitureRepository.existsById(id)) {
			throw new VoitureNotFoundException("Voiture Not Found Exception");
		}
		return voitureRepository.findById(id).get();
	}

	@Override
	public List<Voiture> findAll() throws Exception {
		List<Voiture> listVoiture = (List<Voiture>) voitureRepository.findAll();
		if(listVoiture == null) {
			throw new VoitureNotAvailableException("Voiture Not Available Exception");
		}
		return listVoiture;
	}

	@Override
	public Voiture update(Voiture voiture) throws Exception {
		if(voiture == null) {
			throw new VoitureNullException("Voiture Null Exception");
		}
		if(voiture.getId() == null || !voitureRepository.existsById(voiture.getId())) {
			throw new VoitureNotFoundException("Voiture Not Found Exception");
		}
		if(voiture.getModele() == null || voiture.getMarque() == null|| voiture.getAnnee() == null) {
			throw new VoitureNotValidException("Voiture Not Valid Exception");
		}
		return voiture;
	}

	@Override
	public void delete(Long id) throws Exception {
		if(id == null || !voitureRepository.existsById(id)) {
			throw new VoitureNotFoundException("Voiture Not Found Exception");
		}
		voitureRepository.deleteById(id);
	}



}
