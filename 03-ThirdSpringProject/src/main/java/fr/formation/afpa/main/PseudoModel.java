package fr.formation.afpa.main;

import javax.swing.AbstractListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PseudoModel extends AbstractListModel<Product> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PseudoService pseudoService;

	@Override
	public Product getElementAt(int index) {
		return pseudoService.list().get(index);
	}

	@Override
	public int getSize() {
		return pseudoService.list().size();
	}

}
