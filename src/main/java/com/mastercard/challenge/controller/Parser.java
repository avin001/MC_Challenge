package com.mastercard.challenge.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author User
 *
 */
public class Parser {
	
	/**
	 * Parses the given file and builds a list of list of cities interconnected by road.
	 * 
	 * @return
	 */
	public static List<List<String>> parseFile(){
		
		List<List<String>> bigFileList = new ArrayList<>();
		
		List<String> fileList = null;
		
		try {
		      File myObj = new File("C:\\City.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	fileList = new ArrayList<>(); 
		        String data = myReader.nextLine();
		        
		        int commaIndex = data.indexOf(",");
		        fileList.add(data.substring(0, commaIndex));
		        fileList.add(data.substring(commaIndex +2, data.length()));
		        Collections.sort(fileList);
		        
		        System.out.println(data);
		        bigFileList.add(fileList);
		      }
		      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return bigFileList;
	}
}
