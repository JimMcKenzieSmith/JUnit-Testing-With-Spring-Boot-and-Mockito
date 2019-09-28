package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

import static org.mockito.Mockito.*;

public class SomeBusinessMockTest {
	
	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	@Before
	public void before() {
		business.setDataService(dataServiceMock);
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	
	@Test
	public void calculateSum_empty() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSum_one() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, business.calculateSumUsingDataService());
	}
	

}
