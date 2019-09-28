package com.in28minutes.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	// typically we create components and autowire them in
	@Autowired
	private ItemBusinessService businessService;
	
	
	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	
	@GetMapping("/item-from-biz-service")
	public Item getItemFromBizService() {
		return businessService.retrieveHardCodedItem();
	}
	
	@GetMapping("/items")
	public List getAllItems() {
		return businessService.retrieveAllItems();
	}
	

}
