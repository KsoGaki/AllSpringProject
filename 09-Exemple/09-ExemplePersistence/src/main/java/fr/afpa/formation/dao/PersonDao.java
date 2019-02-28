package fr.afpa.formation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.afpa.formation.entity.Person;

@Component
public class PersonDao {

	public List<Person> list() {
		List<Person> listPerson = new ArrayList<Person>();
		listPerson.add(new Person("Nathan", "Lepers"));
		listPerson.add(new Person("First", "Second"));
		listPerson.add(new Person("Uno", "Dos"));
		listPerson.add(new Person("Un", "Deux"));
		return listPerson;
	}
	
}
