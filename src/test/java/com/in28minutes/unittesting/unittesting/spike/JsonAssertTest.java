package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void jsonAssert_strictTrue() throws JSONException {
		
		String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		// here, all elements must be present since strict is set to true
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
	}
	
	@Test
	public void jsonAssert_strictFalse() throws JSONException {
		
		String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"quantity\":100}";
		// here, all elements must be present since strict is set to true
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
	}
	
	// JSONAssert will also tell you the exact element that is failing and doesn't match!
	// ... important for long json responses
	// example: expected quantity was 100 but the actual quantity was 99
	
	
	// ALSO: escape characters are not needed unless there are spaces in the data values
}
