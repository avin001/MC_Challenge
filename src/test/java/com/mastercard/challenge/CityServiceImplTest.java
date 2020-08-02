package com.mastercard.challenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.mastercard.challenge.controller.CityApiRestController;
import com.mastercard.challenge.controller.Parser;
import com.mastercard.challenge.service.CityServiceImpl;

public class CityServiceImplTest {

	@InjectMocks
	CityServiceImpl cityService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testServiceInstantiated(){
		assertNotNull(cityService);
	}
	
	@Test
	public void testParser(){
		List list = Parser.parseFile();
		
		assertNotNull(list);
	}
	
	@Test
	public void testInValidCitiesService() {
		String origin = "Dallas";
		String destination = "Toronto";
		
		Boolean isConnected = cityService.checkCityConnectedByRoad(origin, destination);
		
		assertFalse(isConnected);
	}
	
	@Test
	public void testValidCitiesService() {
		String origin = "Newark";
		String destination = "Boston";
		
		Boolean isConnected = cityService.checkCityConnectedByRoad(origin, destination);
		
		assertTrue(isConnected);
	}
	
	
	
	
}
