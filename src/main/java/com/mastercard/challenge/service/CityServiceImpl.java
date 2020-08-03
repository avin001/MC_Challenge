package com.mastercard.challenge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mastercard.challenge.controller.Parser;

/**
 * 
 * @author User
 *
 */
@Service
public class CityServiceImpl implements CityService {
	
	/**
	 * Checks whether the 2 cities are interconnected by road
	 */
	@Override
	public Boolean checkCityConnectedByRoad(String origin, String destination){
		
		List<String> inputList = new ArrayList<>();
		inputList.add(origin);
		inputList.add(destination);
		Collections.sort(inputList);
		
		Set<List<String>> bigFileList = null;
		
		boolean isRoadConnected = false;
		
		bigFileList = Parser.parseFile();
		if (bigFileList!= null && bigFileList.size() >0){
			isRoadConnected =  bigFileList.stream().anyMatch(e -> e.equals(inputList));
		}
		return isRoadConnected;
	}
}
