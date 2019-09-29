package com.in28minutes.unittesting.unittesting.business;

import java.util.Arrays;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService dataService;
	
	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {		
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	/*
	public int calculateSum(int[] data) {
		int sum = 0;
		for (int i : data) {
			sum += i;
		}
		return sum;
	}*/
	
	public int calculateSumUsingDataService() {
		return Arrays.stream(dataService.retrieveAllData()).reduce(0, Integer::sum);
	}

}
