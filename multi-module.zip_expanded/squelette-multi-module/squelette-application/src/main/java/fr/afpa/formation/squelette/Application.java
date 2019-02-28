package fr.afpa.formation.squelette;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.formation.squelette.persistence.Specie;
import fr.afpa.formation.squelette.service.SpecieService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private Log log = LogFactory.getLog(Application.class);
	
    @Autowired
	SpecieService service;
    
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		List<Specie> list = service.list();
		for (Specie sp:list) {
			log.info("**** "+sp.toString());
		}
	}
    
}
