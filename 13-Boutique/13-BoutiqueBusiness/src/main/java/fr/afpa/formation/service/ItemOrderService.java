package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.ItemOrder;
import fr.afpa.formation.exception.itemorder.ItemOrderAlreadyExistsException;
import fr.afpa.formation.exception.itemorder.ItemOrderNotAvailableException;
import fr.afpa.formation.exception.itemorder.ItemOrderNotFoundException;
import fr.afpa.formation.exception.itemorder.ItemOrderNotValidException;
import fr.afpa.formation.reposiroty.ItemOrderRepository;

@Service
public class ItemOrderService implements IService<ItemOrder, Exception>{

	@Autowired
	ItemOrderRepository itemOrderRepository;
	
	@Override
	public ItemOrder create(ItemOrder itemOrder) throws ItemOrderNotValidException, ItemOrderAlreadyExistsException {
		if(itemOrder == null || itemOrder.getQuantity() == null || itemOrder.getItem() == null || itemOrder.getOrder() == null) {
			throw new ItemOrderNotValidException("ItemOrder Not Valid Exception");
		}
		if(itemOrder.getId() != null && itemOrderRepository.existsById(itemOrder.getId())) {
			throw new ItemOrderAlreadyExistsException("ItemOrder Already Exists Exception");
		}
		itemOrderRepository.save(itemOrder);
		return itemOrder;
	}

	@Override
	public ItemOrder findById(Long id) throws ItemOrderNotFoundException {
		Optional<ItemOrder> itemOrder = itemOrderRepository.findById(id);
		if(!itemOrder.isPresent()) {
			throw new ItemOrderNotFoundException("ItemOrder Not Found Exception");
		}
		return itemOrder.get();
	}

	@Override
	public List<ItemOrder> findAll() throws ItemOrderNotAvailableException {
		List<ItemOrder> listCategory = (List<ItemOrder>) itemOrderRepository.findAll();
		if(listCategory == null) {
			throw new ItemOrderNotAvailableException("ItemOrder Not Available Exception");
		}
		return listCategory;
	}

	@Override
	public void deleteById(Long id) throws ItemOrderNotFoundException {
		if(!itemOrderRepository.existsById(id)) {
			throw new ItemOrderNotFoundException("ItemOrder Not Found Exception");
		}
		itemOrderRepository.deleteById(id);
	}

	@Override
	public ItemOrder update(ItemOrder itemOrder) throws ItemOrderNotValidException, ItemOrderNotFoundException {
		if(itemOrder == null || itemOrder.getQuantity() == null) {
			throw new ItemOrderNotValidException("ItemOrder Not Valid Exception");
		}
		if(itemOrder.getId() == null || !itemOrderRepository.existsById(itemOrder.getId())) {
			throw new ItemOrderNotFoundException("ItemOrder Not Found Exception");
		}
		itemOrderRepository.save(itemOrder);
		return itemOrder;
	}

}
