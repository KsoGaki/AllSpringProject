package fr.afpa;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.entity.Address;
import fr.afpa.entity.Box;
import fr.afpa.entity.Garage;
import fr.afpa.entity.Location;
import fr.afpa.entity.Person;
import fr.afpa.entity.Vehicule;
import fr.afpa.entity.Voiture;
import fr.afpa.repository.AddressRepository;
import fr.afpa.repository.BoxRepository;
import fr.afpa.repository.GarageRepository;
import fr.afpa.repository.LocationRepository;
import fr.afpa.repository.PersonRepository;
import fr.afpa.repository.VehiculeRepository;
import fr.afpa.repository.VoitureRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private Log log = LogFactory.getLog(Application.class);

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	BoxRepository boxRepository;

	@Autowired
	GarageRepository garageRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	VehiculeRepository vehiculeRepository;

	@Autowired
	VoitureRepository voitureRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("");
		String modele = "modele";
		String marque = "marque";
		Date annee = new Date();		
		Voiture voiture = new Voiture(modele, marque, annee);
		voitureRepository.save(voiture);

		String firstName = "Nathan";
		String lastName = "Lepers";
		Person person = new Person(firstName, lastName);		
		personRepository.save(person);

		String immatriculation = "A01-FRDDF-52";
		Vehicule vehicule = new Vehicule(immatriculation, voiture, person);		
		vehiculeRepository.save(vehicule);		

		String adresse = "115 rue du pre des cezes";
		int postalCode = 34160;
		String ville = "Saint Drézéry";
		Address address = new Address(adresse, postalCode, ville);
		addressRepository.save(address);

		String name = "The Garage"; 
		Garage garage = new Garage(name, address);
		garageRepository.save(garage);

		String placementNumber = "A01";
		double area = 25;
		Box box = new Box(placementNumber, area, garage);
		boxRepository.save(box);

		double tarif = 23.23;
		Date startDate = new Date();
		Date endDate = new Date();
		Location location = new Location(box, vehicule, tarif, startDate, endDate);
		locationRepository.save(location);

		placementNumber = "A02";
		area = 55;
		box = new Box(placementNumber, area, garage);
		boxRepository.save(box);

		placementNumber = "A03";
		area = 33;
		box = new Box(placementNumber, area, garage);
		boxRepository.save(box);

		modele = "Twingo";
		marque = "Renault";
		annee = new Date();		
		voiture = new Voiture(modele, marque, annee);
		voitureRepository.save(voiture);

		firstName = "Saïd";
		lastName = "Oubram";
		person = new Person(firstName, lastName);		
		personRepository.save(person);

		immatriculation = "F56-SDR4F-56";
		vehicule = new Vehicule(immatriculation, voiture, person);		
		vehiculeRepository.save(vehicule);	

		tarif = 50.99;
		startDate = new Date();
		endDate = new Date();
		location = new Location(box, vehicule, tarif, startDate, endDate);
		locationRepository.save(location);
		
		placementNumber = "A04";
		area = 44;
		box = new Box(placementNumber, area, garage);
		boxRepository.save(box);

		garage = garageRepository.findById(1L).get();

		log.info(garage.toString());
	}	

}

