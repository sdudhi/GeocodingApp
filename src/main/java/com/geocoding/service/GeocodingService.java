package com.geocoding.service;

import java.io.IOException;
/**
 * 
 * @author sdudhi
 *
 */
public interface GeocodingService {

	public String getAddressFromLatLong(String lat, String longt) throws IOException;

}
