package fr.afpa.formation;

import static org.junit.Assert.assertEquals;

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

import fr.afpa.formation.entity.Voiture;
import fr.afpa.formation.repository.VoitureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallAppTest.class)
@DataJpaTest
public class ApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private VoitureRepository voitureRepository;

	@Before
	public void setUp() {
		String modele = "modele";
		String marque = "marque";
		Date annee = new Date();		
		Voiture voiture = new Voiture(modele, marque, annee);
		voiture = testEntityManager.persist(voiture);
	}	

	@Test
	public void testVoiture() {
		List<Voiture> listVoiture = (List<Voiture>) voitureRepository.findAll();
		System.out.println(listVoiture.size());
		assertEquals(listVoiture.size(), 1);
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


