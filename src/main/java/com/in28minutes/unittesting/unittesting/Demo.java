package com.in28minutes.unittesting.unittesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Demo {

	public static void main(String[] args) {
		
		
		int[] arr = new int[] {1,2,3,4};
		
		int result = Arrays.stream(arr).reduce(0, Integer::sum);
		
		System.out.println(result);
		
		
		List<String> list = Arrays.asList("Jim", "Bob", "Joe", "Harry");
		
		String str = list.stream().reduce((a, b) -> a + "-" + b).orElse("");
		
		System.out.println(str);

	}

}
