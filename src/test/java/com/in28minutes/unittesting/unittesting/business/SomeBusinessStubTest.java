package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;
import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;


class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}
	
}

public class SomeBusinessStubTest {
	
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(new SomeDataServiceStub());
		int actual = business.calculateSumUsingDataService();
		int expected = 6;
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(() -> new int[] {});
		int actual = business.calculateSumUsingDataService();
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateSum_one() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setDataService(() -> new int[] {5});
		int actual = business.calculateSumUsingDataService();
		int expected = 5;
		assertEquals(expected, actual);
	}
	

}
