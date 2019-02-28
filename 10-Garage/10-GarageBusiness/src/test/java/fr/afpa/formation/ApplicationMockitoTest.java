package fr.afpa.formation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fr.afpa.formation.entity.Voiture;
import fr.afpa.formation.repository.VoitureRepository;
import fr.afpa.formation.service.VoitureService;

@RunWith(MockitoJUnitRunner.class) 
public class ApplicationMockitoTest {

	@Mock
	private VoitureRepository voitureRepository;

	@InjectMocks
	private VoitureService voitureService;

	private List<Voiture> listVoiture = new ArrayList<Voiture>();
	

	@Before
	public void setUp() {
		Voiture voiture = new Voiture("MarqueOne", "ModeleOne", new Date(2014));
		voiture.setId(1L);
		listVoiture.add(voiture);
		voiture = new Voiture("MarqueTwo", "ModeleTwo", new Date(2015));
		voiture.setId(2L);
		listVoiture.add(voiture);
	}

	@Test
	public void findAllTest() throws Exception {
		when(voitureRepository.findAll()).thenReturn(listVoiture);
		
		listVoiture = (List<Voiture>) voitureService.findAll();
		System.out.println(listVoiture);
		assertEquals(listVoiture.size(), 2);
	}

}

