package fr.formation.afpa.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PseudoService {

	@Autowired
	private PseudoDao pseudoDao;

	public List<Product> list() {
		return pseudoDao.list();
	}

	public void deleteById(int idList) {
		pseudoDao.deleteById(idList);
	}

	public void add(String string, int value) {
		pseudoDao.add(string, value);
	}

	public void update(int index, String string, int value) {
		pseudoDao.update(index, string, value);
	}

}
