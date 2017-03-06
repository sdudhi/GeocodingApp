package com.geocoding.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geocoding.model.GoogleResponse;
import com.geocoding.model.Result;

/**
 * 
 * @author sdudhi
 *
 */
@Component
public class GeocodingServiceImpl implements GeocodingService {
	private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";

	/**
	 * Method to get address based on Latitude and Longitude
	 *
	 * @param lat
	 *            String latitude
	 * @param longt
	 *            String longitude
	 *
	 * @exception @link
	 *                IOException
	 * 
	 * @return String.
	 */
	@Override
	public String getAddressFromLatLong(String lat, String longt) throws IOException {
		
		// Construct a string by combining the latitude and longitude
		String latlongString = lat + "," + longt;

		// Create an java.net.URL object by passing the request URL in
		// constructor
		// sensor indicates whether or not the geocoding request comes from a
		// device with a location sensor. This value must be either true or
		// false.
		URL url = new URL(URL + "?latlng=" + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");

		// Open the Connection
		URLConnection conn = url.openConnection();

		InputStream in = conn.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		GoogleResponse response = (GoogleResponse) mapper.readValue(in, GoogleResponse.class);
		in.close();

		String address = "";
		if (response.getStatus().equals("OK")) {
			// GoogleResponse.getResults() returns list of addresses , fetching
			// the initial element from array
			address = response.getResults()[0].getFormatted_address();
		} else {
			address = "Address not found";
		}

		return address;
	}

}
