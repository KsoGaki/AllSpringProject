package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Category;
import fr.afpa.formation.exception.category.CategoryAlreadyExistsException;
import fr.afpa.formation.exception.category.CategoryNotAvailableException;
import fr.afpa.formation.exception.category.CategoryNotFoundException;
import fr.afpa.formation.exception.category.CategoryNotValidException;
import fr.afpa.formation.reposiroty.CategoryRepository;

@Service
public class CategoryService implements IService<Category, Exception>{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category create(Category category) throws CategoryNotValidException, CategoryAlreadyExistsException {
		if(category == null || category.getName() == null) {
			throw new CategoryNotValidException("Category Not Valid Exception");
		}
		if(category.getId() != null && categoryRepository.existsById(category.getId())) {
			throw new CategoryAlreadyExistsException("Category Already Exists Exception");
		}
		categoryRepository.save(category);
		return category;
	}

	@Override
	public Category findById(Long id) throws CategoryNotFoundException {
		Optional<Category> category = categoryRepository.findById(id);
		if(!category.isPresent()) {
			throw new CategoryNotFoundException("Category Not Found Exception");
		}
		return category.get();
	}

	@Override
	public List<Category> findAll() throws CategoryNotAvailableException {
		List<Category> listCategory = (List<Category>) categoryRepository.findAll();
		if(listCategory == null) {
			throw new CategoryNotAvailableException("Category Not Available Exception");
		}
		return listCategory;
	}

	@Override
	public void deleteById(Long id) throws CategoryNotFoundException {
		if(!categoryRepository.existsById(id)) {
			throw new CategoryNotFoundException("Category Not Found Exception");
		}
		categoryRepository.deleteById(id);
	}

	@Override
	public Category update(Category category) throws CategoryNotValidException, CategoryNotFoundException {
		if(category == null || category.getName() == null) {
			throw new CategoryNotValidException("Category Not Valid Exception");
		}
		if(category.getId() == null || !categoryRepository.existsById(category.getId())) {
			throw new CategoryNotFoundException("Category Not Found Exception");
		}
		categoryRepository.save(category);
		return category;
	}

}
