package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import com.in28minutes.unittesting.unittesting.model.Item;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	

	@InjectMocks
	ItemBusinessService business;
	
	@Mock
	ItemRepository repository;
	
	@Test
	public void retrieveAllItems_basic() {
		
		// when business.retrieveAllItems() is called below, we
		// need to mock the functionality of repository.findAll()
		// which will be called inside retrieveAllItems()
		// In this way, we are injecting one mock into the business
		// object so that it does not need to actually connect to the database
		// but we still test the functionality of setting the value
		// to quantity * price
		when(repository.findAll())
			.thenReturn(Arrays.asList(new Item(2,"Item2",10,10),new Item(3,"Item3",20,20)));
		
		assertEquals(100, business.retrieveAllItems().get(0).getValue());
		assertEquals(400, business.retrieveAllItems().get(1).getValue());
	}
	
}
