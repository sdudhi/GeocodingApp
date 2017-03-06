package com.geocoding.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geocoding.service.GeocodingService;
/**
 * 
 * @author sdudhi
 *
 */
@RestController
@RequestMapping("/data")
public class GeocodingController {
	@Autowired
	private GeocodingService personService;

	@RequestMapping("/getAddress")
	public String getAddress(@RequestParam("lat") String lat, @RequestParam("longt") String longt) throws IOException {
		String address = personService.getAddressFromLatLong(lat, longt);
		return address;
	}
}