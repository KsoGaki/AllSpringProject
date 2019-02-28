package fr.formation.afpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PseudoDao {
	
	public List<String> list() {
		List<String> listSting = new ArrayList<String>();
		listSting.add("AAA");
		listSting.add("BBB");
		listSting.add("CCC");
		listSting.add("DDD");
		listSting.add("EEE");
		return listSting;	
	}

}
