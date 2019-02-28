package fr.afpa.formation;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.formation.entity.Person;
import fr.afpa.formation.service.PersonService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	PersonService personService;
	
	private Log log = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("");
		List<Person> listPerson = personService.list();
		for(Person person : listPerson) {
			log.info(person);
		}
		log.info("");
	}

}

