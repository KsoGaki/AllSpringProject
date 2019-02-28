package fr.formation.afpa.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PseudoDao {
	
	List<Product> listProduct;
	
	public List<Product> list() {
		return listProduct;	
	}
	
	public void deleteById(int idList) {
		listProduct.remove(idList);
	}
	
	public void add(String string, int value) {
		listProduct.add(new Product(string, value));	
	}
	
	public void update(int index, String string, int value) {
		listProduct.get(index).setString(string);
		listProduct.get(index).setValue(value);
	}
	
	public PseudoDao() {
		listProduct = new ArrayList<Product>();
		listProduct.add(new Product("AAA", 5));
		listProduct.add(new Product("BBB", 8));
		listProduct.add(new Product("CCC", 1));
		listProduct.add(new Product("DDD", 5));
		listProduct.add(new Product("EEE", 56));
	}

}
