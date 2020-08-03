package com.mastercard.challenge.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author User
 *
 */
public class Parser {
	
	private static Set<List<String>> bigFileList = new HashSet<>();
	
	private static final Logger log = LoggerFactory.getLogger(Parser.class);
	
	/**
	 * Parses the given file and builds a list of list of cities interconnected by road.
	 * 
	 * @return
	 */
	public static Set<List<String>> parseFile(){
		
		List<String> fileList = null;
		
		if (bigFileList.size()==0 ) {
			try {
				  log.info("Opening connection to File...");
			      File myObj = new File("C:\\City.txt");
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			    	fileList = new ArrayList<>(); 
			        String data = myReader.nextLine();
			        
			        int commaIndex = data.indexOf(",");
			        fileList.add(data.substring(0, commaIndex));
			        fileList.add(data.substring(commaIndex +2, data.length()));
			        Collections.sort(fileList);
			        
			        log.info(data);
			        bigFileList.add(fileList);
			      }
			      myReader.close();
		    } catch (FileNotFoundException e) {
		    	log.error("An error occurred.");
		      e.printStackTrace();
		    }
		}
		return bigFileList;
	}
}
