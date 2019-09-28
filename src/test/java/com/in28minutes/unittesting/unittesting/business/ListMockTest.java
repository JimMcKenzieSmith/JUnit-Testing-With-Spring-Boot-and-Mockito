package com.in28minutes.unittesting.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class ListMockTest {
	
	List<String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("hello Jim");
		assertEquals("hello Jim", mock.get(0));
		assertEquals(null, mock.get(1)); // default value is returned for all other parameter values
		
	}
	
	@Test
	public void returnWithGenericParameters() {
		// the any___ methods are called an "argument matcher"
		when(mock.get(anyInt())).thenReturn("hello Jim");
		assertEquals("hello Jim", mock.get(0));
		assertEquals("hello Jim", mock.get(1)); // default value is returned for all other parameter values
		
	}
	
	@Test
	public void verificationBasics() {
		// system under test SUT
		String value = mock.get(0);
		
		// this is useful if the method does not have a return
		// value and you just need to know if the method was called
		// (not the best example, above, because get(0) does have a 
		// return value of String
		
		// Verify the method was called with an int
		verify(mock).get(0);
		verify(mock).get(anyInt());
		verify(mock, times(1)).get(anyInt());
	}
	
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("Somestring");
		
		// here we are passing an argument into a function
		// how do we test that the correct arugument was passed in?
		// use ArgumentCaptor
		
		//Verification with argument captor
		// Verify and then assert the method was called with a certain
		// argument
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("Somestring", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("Somestring");
		mock.add("Somestring2");
		
		// here we are passing an argument into a function
		// how do we test that the correct arugument was passed in?
		// use ArgumentCaptor
		
		//Verification with argument captor
		// Verify and then assert the method was called with a certain
		// argument
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		// by default, when you call verify(mock) it checks that the
		// method is called only once... so you need times(2)
		verify(mock, times(2)).add(captor.capture());
		
		List<String> values = captor.getAllValues();
		
		assertEquals("Somestring", values.get(0));
		assertEquals("Somestring2", values.get(1));
		
	}
	
	@Test
	public void mocking() {
		
		// mocking is "instead of the real world action"
		
		ArrayList arrayListMock = mock(ArrayList.class);
		when(arrayListMock.size()).thenReturn(5);
		assertEquals(5, arrayListMock.size());
	}
	
	@Test
	public void spying() {
		// for a spy, the original behavior of the class is retained
		// in this case, the array list
		
		// spying is where you allow the action to happen in the actual
		// class and you observe the behavior (if you don't have access
		// to the specific class)... you can do verifications on it
		
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("test");
		arrayListSpy.add("test2");
		//when(arrayListMock.size()).thenReturn(5);
		assertEquals(2, arrayListSpy.size());
	}

}
