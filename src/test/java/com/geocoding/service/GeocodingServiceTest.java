/**
 * 
 */
package com.geocoding.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sdudhi
 *
 */
public class GeocodingServiceTest {
	
	GeocodingService geocodingService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 geocodingService = new GeocodingServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		 geocodingService = null;
	}

	@Test
	public void testGetAddressFromLatLongEmpty() throws IOException {
		String address = geocodingService.getAddressFromLatLong("", "");
		assertEquals("Address not found", address);
	}

	@Test
	public void testGetAddressFromLatLongValid() throws IOException {
		String expectedAddress = "1900 McCarthy Blvd, Milpitas, CA 95035, USA";
		String address = geocodingService.getAddressFromLatLong("37.399111","-121.912925");
		assertEquals(expectedAddress, address);

	}
}
