package fr.afpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallAppTest.class)
@DataJpaTest
public class ApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;
	
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

	private int nbBike = 0;
	private int nbCountry = 0;
	private int nbPerson = 0;
	private int nbPlace = 0;
	private int nbRace = 0;
	private int nbRacer = 0;
	private int nbTeam = 0;

	private <T> List<T> findAll(Class<T> klass){
		List<T> listObject = new ArrayList<>();
		long i = 1;
		T tObject = testEntityManager.find(klass, i);
		while(tObject != null) {
			listObject.add(tObject);
			i++;
			tObject = testEntityManager.find(klass, i);
		}
		return listObject;
	}

	@Before
	public void setUp() {
		Person firstTeamLeader = new Person("Uno", "One"); 	
		Person secondTeamLeader = new Person("Dos", "Two"); 	
		Person thirdTeamLeader = new Person("Tres", "Three"); 		
		firstTeamLeader = testEntityManager.persist(firstTeamLeader);
		secondTeamLeader = testEntityManager.persist(secondTeamLeader);
		thirdTeamLeader = testEntityManager.persist(thirdTeamLeader);
		nbPerson += 3;

		Team firstTeam = new Team("Uno", thirdTeamLeader); 
		Team secondTeam = new Team("Dos", firstTeamLeader);
		Team thirdTeam = new Team("Tres", secondTeamLeader);	
		firstTeam = testEntityManager.persist(firstTeam);
		secondTeam = testEntityManager.persist(secondTeam);
		thirdTeam = testEntityManager.persist(thirdTeam);
		nbTeam += 3;

		Person firstPerson = new Person("Un", "Uno");
		Person secondPerson = new Person("Deux", "Dos");
		Person thirdPerson = new Person("Trois", "Tres");
		firstPerson = testEntityManager.persist(firstPerson);
		secondPerson = testEntityManager.persist(secondPerson);
		thirdPerson = testEntityManager.persist(thirdPerson);
		nbPerson += 3;

		Racer firstRacer = new Racer(firstTeam, thirdPerson);
		Racer secondRacer = new Racer(secondTeam, secondPerson);
		Racer thirdRacer = new Racer(thirdTeam, firstPerson);
		firstRacer = testEntityManager.persist(firstRacer);
		secondRacer = testEntityManager.persist(secondRacer);
		thirdRacer = testEntityManager.persist(thirdRacer);
		nbRacer += 3;

		Bike firstBike = new Bike("UnoBrando", "UnaModela", 5, 1, firstRacer);
		Bike secondBike = new Bike("TresBrando", "DosModela", 4, 3, firstRacer);
		Bike thirdBike = new Bike("TresBrando", "DosModela", 4, 3, secondRacer);
		firstBike = testEntityManager.persist(firstBike);
		secondBike = testEntityManager.persist(secondBike);
		thirdBike = testEntityManager.persist(thirdBike);
		nbBike += 3;

		Country firstCountry = new Country("France", "FR");
		Country secondCountry = new Country("Belgique", "BE");
		firstCountry = testEntityManager.persist(firstCountry);
		secondCountry = testEntityManager.persist(secondCountry);
		nbCountry += 2;

		Place firstPlace = new Place("Montpellier", firstCountry);
		Place secondPlace = new Place("Paris", firstCountry);
		Place thirdPlace = new Place("La Pagne", secondCountry);
		firstPlace = testEntityManager.persist(firstPlace);
		secondPlace = testEntityManager.persist(secondPlace);
		thirdPlace = testEntityManager.persist(thirdPlace);
		nbPlace += 3;

		Race firstRace = new Race("FirstaRaca", firstPlace);
		Race secondRace = new Race("SecondoRaco", thirdPlace);
		Race thirdRace = new Race("ThirdaRaca", secondPlace);
		firstRace = testEntityManager.persist(firstRace);
		secondRace = testEntityManager.persist(secondRace);
		thirdRace = testEntityManager.persist(thirdRace);
		nbRace += 3;

	}

	@Test
	public void testPerson() {
		List<Person> listPerson = (List<Person>) personRepository.findAll();
		assertEquals(listPerson.size(), nbPerson);
		
		Person personFind = new Person("New FirstName", "New LastName");
		personRepository.save(personFind);
		assertEquals(personRepository.findById(personFind.getId()).get(), personFind);
	
		String updatedFirstName = "Update FirstName";
		personFind.setFirstName(updatedFirstName);
		personFind = personRepository.save(personFind);
		assertEquals(personRepository.findById(personFind.getId()).get().getFirstName(), updatedFirstName);
		
		long deletedId = personFind.getId();
		personRepository.delete(personFind);
		assertFalse(personRepository.findById(deletedId).isPresent());
	}

	@Test
	public void testTeam() {
		List<Team> listTeam = findAll(Team.class);
		assertEquals(listTeam.size(), nbTeam);
		
		Person teamLeaderFind = new Person("New FirstNameLeader", "New LastNameLeader");
		personRepository.save(teamLeaderFind);
		Team teamFind = new Team("New Team", teamLeaderFind);
		teamRepository.save(teamFind);
		assertEquals(teamRepository.findById(teamFind.getId()).get(), teamFind);
		
		String updatedTeamName = "Update TeamName";
		teamFind.setTeamName(updatedTeamName);
		teamFind = teamRepository.save(teamFind);
		assertEquals(teamRepository.findById(teamFind.getId()).get().getTeamName(), updatedTeamName);
		
		long deletedId = teamFind.getId();
		teamRepository.delete(teamFind);
		assertFalse(teamRepository.findById(deletedId).isPresent());
	}

	@Test
	public void testRacer() {
		List<Racer> listRacer = findAll(Racer.class);
		assertEquals(listRacer.size(), nbRacer);
		
		Person teamLeaderFind = new Person("New FirstNameLeader", "New LastNameLeader");
		personRepository.save(teamLeaderFind);
		Team teamFind = new Team("New Team", teamLeaderFind);
		teamRepository.save(teamFind);
		Person personFind = new Person("New FirstName", "New LastName");
		personRepository.save(personFind);
		Racer racerFind = new Racer(teamFind, personFind);
		racerRepository.save(racerFind);
		assertEquals(racerRepository.findById(racerFind.getId()).get(), racerFind);
				
		long deletedId = racerFind.getId();
		testEntityManager.remove(racerFind);
		assertFalse(racerRepository.findById(deletedId).isPresent());
	}

	@Test
	public void testBike() {
		List<Bike> listBike = findAll(Bike.class);
		assertEquals(listBike.size(), nbBike);

		Person teamLeaderFind = new Person("New FirstNameLeader", "New LastNameLeader");
		personRepository.save(teamLeaderFind);
		Team teamFind = new Team("New Team", teamLeaderFind);
		teamRepository.save(teamFind);
		Person personFind = new Person("New FirstName", "New LastName");
		personRepository.save(personFind);
		Racer racerFind = new Racer(teamFind, personFind);
		racerRepository.save(racerFind);
		Bike bikeFind = new Bike("New Brand", "New Model", 1, 1, racerFind);
		bikeRepository.save(bikeFind);
		assertEquals(bikeRepository.findById(bikeFind.getId()).get(), bikeFind);

		String updatedBrand = "Update Brand";
		bikeFind.setBrand(updatedBrand);
		bikeFind = bikeRepository.save(bikeFind);
		assertEquals(bikeRepository.findById(bikeFind.getId()).get().getBrand(), updatedBrand);

		long deletedId = bikeFind.getId();
		bikeRepository.delete(bikeFind);
		assertFalse(bikeRepository.findById(deletedId).isPresent());

	}

	@Test
	public void testCountry() {
		List<Country> listCountry = findAll(Country.class);
		assertEquals(listCountry.size(), nbCountry);
		
		Country countryFind = new Country("New Country", "NC");
		countryRepository.save(countryFind);
		assertEquals(countryRepository.findById(countryFind.getId()).get(), countryFind);
		
		String updatedCountryName = "Update Country";
		countryFind.setCountryName(updatedCountryName);
		countryFind = countryRepository.save(countryFind);
		assertEquals(countryRepository.findById(countryFind.getId()).get().getCountryName(), updatedCountryName);

		long deletedId = countryFind.getId();
		countryRepository.delete(countryFind);
		assertFalse(countryRepository.findById(deletedId).isPresent());
	}

	@Test
	public void testPlace() {
		List<Place> listPlace = findAll(Place.class);
		assertEquals(listPlace.size(), nbPlace);
		
		Country countryFind = new Country("New Country", "NC");
		countryRepository.save(countryFind);
		Place placeFind = new Place("New City", countryFind);
		placeRepository.save(placeFind);
		assertEquals(placeRepository.findById(placeFind.getId()).get(), placeFind);
		
		String updatedPlaceName = "Update CityName";
		placeFind.setCityName(updatedPlaceName);
		placeFind = placeRepository.save(placeFind);
		assertEquals(placeRepository.findById(placeFind.getId()).get().getCityName(), updatedPlaceName);		
		
		long deletedId = placeFind.getId();
		placeRepository.delete(placeFind);
		assertFalse(placeRepository.findById(deletedId).isPresent());
	}

	@Test
	public void testRace() {
		List<Race> listRace = findAll(Race.class);
		assertEquals(listRace.size(), nbRace);
		
		Person teamLeaderFind = new Person("New FirstNameLeader", "New LastNameLeader");
		personRepository.save(teamLeaderFind);
		Team teamFind = new Team("New Team", teamLeaderFind);
		teamRepository.save(teamFind);
		Person personFind = new Person("New FirstName", "New LastName");
		personRepository.save(personFind);
		Racer racerFind = new Racer(teamFind, personFind);
		racerRepository.save(racerFind);
		Bike bikeFind = new Bike("New Brand", "New Model", 1, 1, racerFind);
		bikeRepository.save(bikeFind);
		Country countryFind = new Country("New Country", "NC");
		countryRepository.save(countryFind);
		Place placeFind = new Place("New City", countryFind);
		placeRepository.save(placeFind);
		Race raceFind = new Race("New Race", placeFind);
		raceRepository.save(raceFind);
		raceFind.getListTeam().add(teamFind);
		raceRepository.save(raceFind);
		assertEquals(raceRepository.findById(raceFind.getId()).get(), raceFind);
		
		String updatedRaceName = "Update RaceName";
		raceFind.setRaceName(updatedRaceName);
		raceFind = raceRepository.save(raceFind);
		assertEquals(raceRepository.findById(raceFind.getId()).get().getRaceName(), updatedRaceName);		
		
		long deletedId = raceFind.getId();
		raceRepository.delete(raceFind);
		assertFalse(raceRepository.findById(deletedId).isPresent());
		
	}

	@After
	public void tearDown() {
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Bike ALTER COLUMN id_Bike RESTART WITH 1").executeUpdate();
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Country ALTER COLUMN id_Country RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Person ALTER COLUMN id_Person RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Place ALTER COLUMN id_Place RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Race ALTER COLUMN id_Race RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Racer ALTER COLUMN id_Racer RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Team ALTER COLUMN id_Team RESTART WITH 1").executeUpdate(); 
	}

}

