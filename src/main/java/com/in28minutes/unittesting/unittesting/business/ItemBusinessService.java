package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {
	
	@Autowired // since it is a dependency, you auto wire it in
	private ItemRepository repository;

	public Item retrieveHardCodedItem() {
		Item item = new Item(1, "Ball", 10, 100);
		// in a real world scenario, we would likely have some 
		// business logic in here that changes the item in some way 
		// after it is retrieve from a data source, for example...
		// so mocking this method in method in ItemControllerTest
		// will effectively exercise this business logic
		return item;
	}
	
	public List<Item> retrieveAllItems() {
		
		List<Item> items = repository.findAll();
		
		for (Item item : items) {
			
			item.setValue(item.getPrice() * item.getQuantity());
			
		}
		
		return items;
	}

}
