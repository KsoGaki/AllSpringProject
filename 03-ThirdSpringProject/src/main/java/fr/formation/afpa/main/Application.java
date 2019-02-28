package fr.formation.afpa.main;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PseudoJFrame pseudoJFrame;

	public static void main(String[] args) {
		//ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class).headless(false).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		EventQueue.invokeLater(() -> {
			pseudoJFrame.start();
			pseudoJFrame.setVisible(true);
		});
	}

}
