package fr.afpa.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.formation.service.SpecieService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	SpecieService specieService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		specieService.findAll();
	}

}
