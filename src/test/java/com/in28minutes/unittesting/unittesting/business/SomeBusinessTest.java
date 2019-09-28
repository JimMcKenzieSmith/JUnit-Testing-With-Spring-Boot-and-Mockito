package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;
import org.junit.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actual = business.calculateSum(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actual = business.calculateSum(new int[] {});
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateSum_one() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actual = business.calculateSum(new int[] {5});
		int expected = 5;
		assertEquals(expected, actual);
	}
	

}
