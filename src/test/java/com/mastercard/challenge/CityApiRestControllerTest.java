package com.mastercard.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mastercard.challenge.controller.CityApiRestController;
import com.mastercard.challenge.service.CityService;
import static org.mockito.Mockito.*;

public class CityApiRestControllerTest {

	@InjectMocks
	CityApiRestController cityControllerMock;
	
	@Mock
	CityService cityServiceMock;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testInValidCitiesController() {
		String origin = "Dallas";
		String destination = "Manhattan";
		
		when(cityServiceMock.checkCityConnectedByRoad(origin, destination)).thenReturn(false);
		
		String cityConnection = cityControllerMock.checkCityConnection(origin, destination);
		
		Assert.assertEquals("No", cityConnection);
		
	}
	
	@Test
	public void testValidCitiesController() {
		String origin = "Newark";
		String destination = "Boston";
		
		when(cityServiceMock.checkCityConnectedByRoad(origin, destination)).thenReturn(true);
		
		String cityConnection = cityControllerMock.checkCityConnection(origin, destination);
		
		Assert.assertEquals("Yes", cityConnection);
		
		
	}
}
