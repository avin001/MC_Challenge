package com.mastercard.challenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface which exposes the REST endpoint
 * @author User
 *
 */
public interface CityApi {

	@GetMapping("/connected")
	public String checkCityConnection(@RequestParam("origin")String origin, @RequestParam("destination")String destination );
	
}
