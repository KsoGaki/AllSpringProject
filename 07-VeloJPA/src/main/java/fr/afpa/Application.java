package fr.afpa;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.entity.Bike;
import fr.afpa.entity.Country;
import fr.afpa.entity.Person;
import fr.afpa.entity.Place;
import fr.afpa.entity.Race;
import fr.afpa.entity.Racer;
import fr.afpa.entity.Team;
import fr.afpa.repository.BikeRepository;
import fr.afpa.repository.CountryRepository;
import fr.afpa.repository.PersonRepository;
import fr.afpa.repository.PlaceRepository;
import fr.afpa.repository.RaceRepository;
import fr.afpa.repository.RacerRepository;
import fr.afpa.repository.TeamRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private Log log = LogFactory.getLog(Application.class);
	
	@Autowired
	BikeRepository bikeRepository;

	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PlaceRepository placeRepository;
	
	@Autowired
	RaceRepository raceRepository;
	
	@Autowired
	RacerRepository racerRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	//@Transactional
	public void run(String... args) throws Exception {
		log.info("Program Start -");
		
		Person teamLeader = new Person("The", "Leader");
		teamLeader = personRepository.save(teamLeader);
		
		Team team = new Team("The Team", teamLeader);
		team = teamRepository.save(team);
		
		Person person = new Person("The", "Racer");
		person = personRepository.save(person);
		
		Racer racer = new Racer(team, person);
		racer = racerRepository.save(racer);
		
		Bike bike = new Bike("Brand", "Model", 5, 3, racer);
		bike = bikeRepository.save(bike);
		
		Country country = new Country("France", "FR");
		country = countryRepository.save(country);
		
		Place place = new Place("Montpellier", country);
		place = placeRepository.save(place);
		
		Race race = new Race("The race", place);
		race = raceRepository.save(race);
		race.getListTeam().add(team);
		race = raceRepository.save(race);
		
		race = raceRepository.findById(race.getId()).get();
		log.info(race.toString());

		log.info("");
		log.info("Program End -");
		
	}

}

