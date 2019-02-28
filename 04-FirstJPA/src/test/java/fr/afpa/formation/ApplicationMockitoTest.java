package fr.afpa.formation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import fr.afpa.formation.business.exception.SpecieAlreadyExistsException;
import fr.afpa.formation.business.exception.SpecieNotAvailableException;
import fr.afpa.formation.business.exception.SpecieNotFoundException;
import fr.afpa.formation.business.exception.SpecieNotValidException;
import fr.afpa.formation.business.service.SpecieService;
import fr.afpa.formation.persistence.entity.Specie;
import fr.afpa.formation.persistence.repository.SpecieRepository;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class ApplicationMockitoTest {

	@Mock
	private SpecieRepository specieRepository;

	@InjectMocks
	private SpecieService specieService;

	private List<Specie> listSpecie = new ArrayList<>();

	@Before
	public void setUp() {
		Specie specie = new Specie("Lapin", "Lapinus");
		specie.setId(1L);
		listSpecie.add(specie);
		specie = new Specie("Cat", "Catus");
		specie.setId(2L);
		listSpecie.add(specie);
	}
	
	public boolean existsMockById(Long id) {
		for(Specie specie : listSpecie) {
			if(specie.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Specie findMockSpecieById(Long id) {
		for(Specie specie : listSpecie) {
			if(specie.getId() == id) {
				return specie;
			}
		}
		return null;
	}

	@Test
	public void findAllTest() {
		when(specieRepository.findAll()).thenReturn(listSpecie);
		
		try {
			int listSize = specieService.findAll().size();
			assertEquals(2, listSize);	
		} catch (SpecieNotAvailableException e) {
			assertNull(e);
		}
		
		listSpecie.clear();
		
		try {
			specieService.findAll();
			assertTrue(false);
		} catch (SpecieNotAvailableException e) {
			e.printStackTrace();	
			assertNotNull(e);
		}
		
		
	
	}

	@Test
	public void findByIdTest() {	
		Specie specie = new Specie("Lapin", "Lapinus");
		specie.setId(2L);
		Long id = 1L;
		when(specieRepository.findById(id)).thenReturn(Optional.of(findMockSpecieById(id)));
		
		try {
			assertEquals("Lapinus", specieService.findById(id).getLatinName());
		} catch (SpecieNotFoundException e) {
			assertNull(e);
		}

		try {
			id = -1L;
			specieService.findById(id);
			assertTrue(false);
		} catch (SpecieNotFoundException e) {
			assertNotNull(e);
			e.printStackTrace();
		}

	}
	
	@Test
	public void deleteByIdTest() {
		doAnswer(new Answer<Void>(){
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] objects = invocation.getArguments();
				if (objects != null && objects.length != 0 && objects[0] != null) {
					Long id = (Long) objects[0];
					for(Specie specie : listSpecie) {
						if(specie.getId() == id) {
							listSpecie.remove(specie);
						}
					}
				}
				return null;
			}
		}).when(specieRepository).deleteById(Mockito.anyLong());

		Long id = 1L;
		try {
			specieService.deleteById(id);
			Specie specie = findMockSpecieById(id);
			assertNull(specie);
		} catch (SpecieNotFoundException e) {
			e.printStackTrace();
			assertNull(e);
		}
		
		try {
			id = null;
			specieService.deleteById(id);
			findMockSpecieById(id);
			assertTrue(false);
		} catch (SpecieNotFoundException e) {
			e.printStackTrace();
			assertNotNull(e);
		}
	}
	
	@Test
	public void deleteTest() {
		doAnswer(new Answer<Void>(){
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] objects = invocation.getArguments();
				if (objects != null && objects.length != 0 && objects[0] != null) {
					Specie specie = (Specie) objects[0];
					listSpecie.remove(specie);
				}
				return null;
			}
		}).when(specieRepository).delete(Mockito.any(Specie.class));
		Specie specie = null;
		try {
			specieService.delete(specie);
			assertTrue(false);
		} catch (SpecieNotFoundException e) {
			e.printStackTrace();
			assertNotNull(e);
		}
		
		try {
			specie = listSpecie.get(0);
			specieService.delete(specie);
			assertFalse(listSpecie.contains(specie));
		} catch (SpecieNotFoundException e) {
			e.printStackTrace();
			assertNull(e);
		}
	}

	@Test
	public void createTest() throws SpecieNotValidException, SpecieAlreadyExistsException {
		doAnswer(new Answer<Void>(){
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] objects = invocation.getArguments();
				if (objects != null && objects.length != 0 && objects[0] != null) {
					Specie specie = (Specie) objects[0];
					specie.setId(12L);
					listSpecie.add(specie);
				}
				return null;
			}
		}).when(specieRepository).save(Mockito.any(Specie.class));
		Specie specie = new Specie();
		specie.setCommonName("Dog");
		specie.setLatinName("Dogus");
		specieService.create(specie);
		assertEquals(3, listSpecie.size());
		assertEquals((Long) 12L, listSpecie.get(2).getId());
	}

	@Test
	public void updateTest() throws SpecieNotValidException, SpecieAlreadyExistsException {
		doAnswer(new Answer<Void>(){
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] objects = invocation.getArguments();
				if (objects != null && objects.length != 0 && objects[0] != null) {
					Specie specieValue = (Specie) objects[0];
					Specie specieToUpdate = findMockSpecieById(specieValue.getId());
					specieToUpdate.setCommonName(specieValue.getCommonName());
					specieToUpdate.setLatinName(specieValue.getLatinName());
				}
				return null;
			}
		}).when(specieRepository).save(Mockito.any(Specie.class));
		Specie specie = new Specie(1L, "Saïd", "SaïDanus");
		specieService.update(specie);
		assertEquals(listSpecie.get(0).getLatinName(), "SaïDanus");
	}



}

