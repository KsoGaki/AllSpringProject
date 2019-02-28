package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Item;
import fr.afpa.formation.exception.item.ItemAlreadyExistsException;
import fr.afpa.formation.exception.item.ItemNotAvailableException;
import fr.afpa.formation.exception.item.ItemNotFoundException;
import fr.afpa.formation.exception.item.ItemNotValidException;
import fr.afpa.formation.reposiroty.ItemRepository;

@Service
public class ItemService implements IService<Item, Exception>{

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Item create(Item item) throws ItemNotValidException, ItemAlreadyExistsException {
		if(item == null || item.getName() == null || item.getCode() == null || item.getPrice() == null || item.getCategory() == null) {
			throw new ItemNotValidException("Item Not Valid Exception");
		}
		if(item.getId() != null && itemRepository.existsById(item.getId())) {
			throw new ItemAlreadyExistsException("Item Already Exists Exception");
		}
		itemRepository.save(item);
		return item;
	}

	@Override
	public Item findById(Long id) throws ItemNotFoundException {
		Optional<Item> item = itemRepository.findById(id);
		if(!item.isPresent()) {
			throw new ItemNotFoundException("Item Not Found Exception");
		}
		return item.get();
	}

	@Override
	public List<Item> findAll() throws ItemNotAvailableException {
		List<Item> listItem = (List<Item>) itemRepository.findAll();
		if(listItem == null) {
			throw new ItemNotAvailableException("Item Not Available Exception");
		}
		return listItem;
	}

	@Override
	public void deleteById(Long id) throws ItemNotFoundException {
		if(!itemRepository.existsById(id)) {
			throw new ItemNotFoundException("Item Not Found Exception");
		}
		itemRepository.deleteById(id);
	}

	@Override
	public Item update(Item item) throws ItemNotValidException, ItemNotFoundException {
		if(item == null || item.getName() == null) {
			throw new ItemNotValidException("Item Not Valid Exception");
		}
		if(item.getId() == null || !itemRepository.existsById(item.getId())) {
			throw new ItemNotFoundException("Item Not Found Exception");
		}
		itemRepository.save(item);
		return item;
	}

}
