package fr.afpa.formation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.formation.business.service.SpecieService;
import fr.afpa.formation.persistence.entity.Specie;
import fr.afpa.formation.persistence.repository.AnimalRepository;
import fr.afpa.formation.persistence.repository.PersonRepository;
import fr.afpa.formation.persistence.repository.SpecieRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	SpecieRepository specieRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	SpecieService specieService;

	private Log log = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application Animal");
//		long idSpecie = 1L;
//		String commonName = "Saïd";
//		String latinName = "Saïdus";
//		log.info(specieRepository.findById(idSpecie).get().toString());
//		Specie specie = new Specie(commonName,latinName);
//		specieRepository.save(specie);
//		log.info(animalRepository.findById(idSpecie).get().toString());
//		log.info(personRepository.findById(5L).get().toString());
//		Animal animal = animalRepository.findById(2L).get();
//		Person person = new Person("Nathan", "Lepers", 23);
//		person.getListAnimal().add(animal);
//		personRepository.save(person);
//		log.info(person.getId());
//		personRepository.deleteById(person.getId());
		specieService.create(new Specie("test","test"));
	}

}

