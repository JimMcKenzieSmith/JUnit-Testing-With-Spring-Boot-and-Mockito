package com.in28minutes.unittesting.unittesting.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

import static org.mockito.Mockito.*;

import java.util.Arrays;




@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)  // this annotation indicates that we only want to test the item controller
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void getitem_basic() throws Exception {
		//call GET "/dummy-item"  application/json

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().is(200))
				// json method only checks for this list of elements to be present
				// ... if there are additional elements in the json response, it will STILL 
				// pass!!!
				.andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void itemFromBizService_basic() throws Exception {
		//call GET "/item-from-biz-service"  application/json

		when(businessService.retrieveHardCodedItem())
			.thenReturn(new Item(2,"Item2",10,10));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-biz-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().is(200))
				// json method only checks for this list of elements to be present
				// ... if there are additional elements in the json response, it will STILL 
				// pass!!!
				.andExpect(MockMvcResultMatchers.content().json("{id:2,name:Item2,price:10}"))
				.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void retriveAllItems_basic() throws Exception {
		//call GET "/item-from-biz-service"  application/json

		when(businessService.retrieveAllItems())
			.thenReturn(Arrays.asList(new Item(2,"Item2",10,10),new Item(3,"Item3",20,20)));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/items")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().is(200))
				// json method only checks for this list of elements to be present
				// ... if there are additional elements in the json response, it will STILL 
				// pass!!!
				.andExpect(MockMvcResultMatchers.content().json("[{id:2,name:Item2,price:10},{id:3,name:Item3,price:20}]"))
				.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	

}
