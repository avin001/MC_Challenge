package com.mastercard.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.challenge.service.CityService;

/**
 * Controller class for the REST Api
 * 
 * @author User
 *
 */
@RestController
public class CityApiRestController implements CityApi{ 
	
	@Autowired
	CityService cityService;

	@Override
	public String checkCityConnection(String origin, String destination) {
		
		boolean isCityConnected = cityService.checkCityConnectedByRoad(origin, destination);
		
		String cityConnected = "";
		if (isCityConnected){
			cityConnected = "Yes"; 
		}else {
			cityConnected = "No"; 
		}
		return cityConnected;
	}
	
	
	
	
}
