package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.OrdreReparation;
import fr.afpa.formation.exception.ordrereparation.OrdreReparationAlreadyExistsException;
import fr.afpa.formation.exception.ordrereparation.OrdreReparationNotAvailableException;
import fr.afpa.formation.exception.ordrereparation.OrdreReparationNotFoundException;
import fr.afpa.formation.exception.ordrereparation.OrdreReparationNotValidException;
import fr.afpa.formation.repository.OrdreReparationRepository;

@Service
public class OrdreReparationService implements IService<OrdreReparation, Exception>{

	@Autowired
	OrdreReparationRepository ordreReparationRepository;

	@Override
	public OrdreReparation create(OrdreReparation ordreReparation) throws OrdreReparationNotValidException, OrdreReparationAlreadyExistsException {
		if(ordreReparation == null) {
			throw new OrdreReparationNotValidException("OrdreReparation Not Valid Exception");
		}
		if(ordreReparation.getId() != null && ordreReparationRepository.existsById(ordreReparation.getId())) {
			throw new OrdreReparationAlreadyExistsException("OrdreReparation Already Exists Exception");
		}
		ordreReparationRepository.save(ordreReparation);
		return ordreReparation;
	}

	@Override
	public OrdreReparation findById(Long id) throws OrdreReparationNotFoundException {
		Optional<OrdreReparation> ordreReparation = ordreReparationRepository.findById(id);
		if(!ordreReparation.isPresent()) {
			throw new OrdreReparationNotFoundException("OrdreReparation Not Found Exception");
		}
		return ordreReparation.get();
	}

	@Override
	public List<OrdreReparation> findAll() throws OrdreReparationNotAvailableException {
		List<OrdreReparation> listOrdreReparation = (List<OrdreReparation>) ordreReparationRepository.findAll();
		if(listOrdreReparation == null) {
			throw new OrdreReparationNotAvailableException("OrdreReparation Not Available Exception");
		}
		return listOrdreReparation;
	}

	@Override
	public void deleteById(Long id) throws OrdreReparationNotFoundException {
		if(!ordreReparationRepository.existsById(id)) {
			throw new OrdreReparationNotFoundException("OrdreReparation Not Found Exception");
		}
		ordreReparationRepository.deleteById(id);
	}

	@Override
	public OrdreReparation update(OrdreReparation ordreReparation) throws OrdreReparationNotValidException, OrdreReparationNotFoundException {
		if(ordreReparation == null) {
			throw new OrdreReparationNotValidException("OrdreReparation Not Valid Exception");
		}
		if(ordreReparation.getId() == null || !ordreReparationRepository.existsById(ordreReparation.getId())) {
			throw new OrdreReparationNotFoundException("OrdreReparation Not Found Exception");
		}
		ordreReparationRepository.save(ordreReparation);
		return ordreReparation;
	}

}
