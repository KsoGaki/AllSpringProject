package fr.afpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
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

import fr.afpa.entity.Address;
import fr.afpa.entity.Box;
import fr.afpa.entity.Garage;
import fr.afpa.entity.Location;
import fr.afpa.entity.Person;
import fr.afpa.entity.Vehicule;
import fr.afpa.entity.Voiture;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallAppTest.class)
@DataJpaTest
public class ApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;


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

	private int nbBox;

	@Before
	public void setUp() {
		String modele = "modele";
		String marque = "marque";
		Date annee = new Date();		
		Voiture voiture = new Voiture(modele, marque, annee);
		voiture = testEntityManager.persist(voiture);

		String firstName = "Nathan";
		String lastName = "Lepers";
		Person person = new Person(firstName, lastName);		
		person = testEntityManager.persist(person);

		String immatriculation = "A01-FRDDF-52";
		Vehicule vehicule = new Vehicule(immatriculation, voiture, person);		
		vehicule = testEntityManager.persist(vehicule);		

		String adresse = "115 rue du pre des cezes";
		int postalCode = 34160;
		String ville = "Saint Drézéry";
		Address address = new Address(adresse, postalCode, ville);
		address = testEntityManager.persist(address);

		String name = "The Garage"; 
		Garage garage = new Garage(name, address);
		garage = testEntityManager.persist(garage);

		String placementNumber = "A01";
		double area = 25;
		Box box = new Box(placementNumber, area, garage);
		box = testEntityManager.persist(box);
		System.out.println(box.getId());

		double tarif = 23.23;
		Date startDate = new Date();
		Date endDate = new Date();
		Location location = new Location(box, vehicule, tarif, startDate, endDate);
		location = testEntityManager.persist(location);

		placementNumber = "A02";
		area = 55;
		box = new Box(placementNumber, area, garage);
		box = testEntityManager.persist(box);

		placementNumber = "A03";
		area = 33;
		box = new Box(placementNumber, area, garage);
		box = testEntityManager.persist(box);

		modele = "Twingo";
		marque = "Renault";
		annee = new Date();		
		voiture = new Voiture(modele, marque, annee);
		voiture = testEntityManager.persist(voiture);

		firstName = "Saïd";
		lastName = "Oubram";
		person = new Person(firstName, lastName);		
		person = testEntityManager.persist(person);

		immatriculation = "F56-SDR4F-56";
		vehicule = new Vehicule(immatriculation, voiture, person);		
		vehicule = testEntityManager.persist(vehicule);	

		tarif = 50.99;
		startDate = new Date();
		endDate = new Date();
		location = new Location(box, vehicule, tarif, startDate, endDate);
		location = testEntityManager.persist(location);

		placementNumber = "A04";
		area = 44;
		box = new Box(placementNumber, area, garage);
		box = testEntityManager.persist(box);

		nbBox = 4;
	}	

	@Test
	public void testAddress() {
		List<Address> listAddress = findAll(Address.class);
		System.out.println(listAddress.size());
		Address address = listAddress.get(0);
		assertEquals(address, testEntityManager.find(Address.class, address.getId()));
		
		address = testEntityManager.find(Address.class, -1L);
		assertNull(address);
	}

	@Test
	public void testBox() {
		List<Box> listBox = findAll(Box.class);
		assertEquals(nbBox, listBox.size());

		Box box = listBox.get(0);
		assertEquals(box, testEntityManager.find(Box.class, box.getId()));

		box = testEntityManager.find(Box.class, -1L);
		assertNull(box);
	}

	@Test
	public void testGarage() {
		List<Garage> listGarage = findAll(Garage.class);
		Garage garage = listGarage.get(0);
		assertEquals(garage, testEntityManager.find(Garage.class, garage.getId()));

		garage = testEntityManager.find(Garage.class, -1L);
		assertNull(garage);
	}
	
	@Test
	public void testLocation() {
		List<Location> listLocation = findAll(Location.class);
		Location location = listLocation.get(0);
		assertEquals(location, testEntityManager.find(Location.class, location.getId()));
		
		location.setTarif(7.0);
		location = testEntityManager.persist(location);
		
		long idTest = location.getId();
		testEntityManager.remove(location);
		location = testEntityManager.find(Location.class, idTest);
		assertNull(location);
		
		location = testEntityManager.find(Location.class, -1L);
		assertNull(location);
		
	}

	@After
	public void tearDown() {
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Address ALTER COLUMN id_Address RESTART WITH 1").executeUpdate();
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Box ALTER COLUMN id_Box RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Garage ALTER COLUMN id_Garage RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Location ALTER COLUMN id_Location RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Person ALTER COLUMN id_Person RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Vehicule ALTER COLUMN id_Vehicule RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Voiture ALTER COLUMN id_Voiture RESTART WITH 1").executeUpdate(); 
	}

}


