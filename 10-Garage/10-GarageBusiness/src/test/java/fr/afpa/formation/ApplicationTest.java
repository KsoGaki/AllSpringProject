package fr.afpa.formation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.entity.Voiture;
import fr.afpa.formation.service.VoitureService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallAppTest.class)
@DataJpaTest
public class ApplicationTest {

	@Autowired
	private VoitureService voitureService;

	private List<Voiture> listVoiture = new ArrayList<Voiture>();
	

	@Before
	public void setUp() {
	}

	@Test
	public void findAllTest() throws Exception {
		listVoiture = (List<Voiture>) voitureService.findAll();
		System.out.println(listVoiture);
		assertEquals(listVoiture.size(), 2);
	}

}

