package fr.afpa.formation.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.business.exception.SpecieAlreadyExistsException;
import fr.afpa.formation.business.exception.SpecieNotAvailableException;
import fr.afpa.formation.business.exception.SpecieNotFoundException;
import fr.afpa.formation.business.exception.SpecieNotValidException;
import fr.afpa.formation.persistence.entity.Specie;
import fr.afpa.formation.persistence.repository.SpecieRepository;

@Service
public class SpecieService implements IService<Specie, Exception>{

	@Autowired
	private SpecieRepository specieRepository;

	@Override
	public Specie create(Specie specie) throws SpecieNotValidException, SpecieAlreadyExistsException {
		if(specie == null) {
			throw new SpecieNotValidException("Specie Not Valid Exception");
		}
		if(specie.getId() != null && existsById(specie.getId())) {
			throw new SpecieAlreadyExistsException("Specie Already Exists");
		}
		return specieRepository.save(specie);
	}

	@Override
	public Specie findById(Long id) throws SpecieNotFoundException, SpecieNotAvailableException {
		Optional<Specie> specie = specieRepository.findById(id);
		if(!specie.isPresent()) {
			throw new SpecieNotFoundException("Specie Not Found");
		}
		return specie.get();
	}

	@Override
	public List<Specie> findAll() throws SpecieNotAvailableException {
		List<Specie> listSpecie = (List<Specie>) specieRepository.findAll();
		if(listSpecie == null || listSpecie.size() == 0) {
			throw new SpecieNotAvailableException("Specie Not Available");
		}
		return listSpecie;
	}

	@Override
	public void deleteById(Long id) throws SpecieNotFoundException {
		if(!(id == null)/* && existsById(specie.getId()) */) {
			specieRepository.deleteById(id);
		} else {
			throw new SpecieNotFoundException("Specie By Id Not Found");
		}
	}

	public void delete(Specie specie) throws SpecieNotFoundException {
		if(!(specie == null) /* && existsById(specie.getId()) */) {
			specieRepository.delete(specie);
		} else {
			throw new SpecieNotFoundException("Specie Not Found");
		}
	}

	@Override
	public Specie update(Specie specie) throws SpecieNotValidException, SpecieNotFoundException {
		if(specie.getId() == null || specie.getCommonName() == null || specie.getLatinName() == null) {
			throw new SpecieNotValidException("Specie Not Valid Exception");
		}
		/*if(!existsById(specie.getId())) {
			throw new SpecieNotFoundException("Specie Not Found Exception");
		}*/
		return specieRepository.save(specie);
	}

	public boolean existsById(Long id) {
		return specieRepository.existsById(id);
	}

}
