package com.josiah.training.exercises.classFour;

import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title:</b> StatesMap.java
 * <b>Project:</b> lib
 * <b>Description:</b> exercise one from class four of dev training. 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jul 14, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class StatesMap {
	// init private map to store states
	private Map<String, String> mapOfStates = new HashMap<String, String>();
	
	public StatesMap() {
		mapOfStates.put("AL", "Alabama");
		mapOfStates.put("AK", "Alaska");
		mapOfStates.put("AZ", "Arizona");
		mapOfStates.put("AR", "Arkansas");
		mapOfStates.put("CA", "California");
		mapOfStates.put("CO", "Colorado");
		mapOfStates.put("CT", "Connecticut");
		mapOfStates.put("DE", "Delaware");
		mapOfStates.put("FL", "Florida");
		mapOfStates.put("GA", "Georgia");
		mapOfStates.put("HI", "Hawaii");
		mapOfStates.put("ID", "Idaho");
		mapOfStates.put("IL", "Illinois");
		mapOfStates.put("IN", "Indiana");
		mapOfStates.put("IA", "Iowa");
		mapOfStates.put("KS", "Kansas");
		mapOfStates.put("KY", "Kentucky");
		mapOfStates.put("LA", "Louisiana");
		mapOfStates.put("ME", "Maine");
		mapOfStates.put("MD", "Maryland");
		mapOfStates.put("MA", "Massachusetts");
		mapOfStates.put("MI", "Michigan");
		mapOfStates.put("MN", "Minnesota");
		mapOfStates.put("MN", "Mississippi");
		mapOfStates.put("MO", "Missouri");
//		
//		Montana
//		Nebraska
//		Nevada
//		New Hampshire
//		New Jersey
//		New Mexico
//		New York
//		North Carolina
//		North Dakota
//		Ohio
//		Oklahoma
//		Oregon
//		Pennsylvania
//		Rhode Island
//		South Carolina
//		South Dakota
//		Tennessee
//		Texas
//		Utah
//		Vermont
//		Virginia
//		Washington
//		West Virginia
//		Wisconsin
//		Wyoming
	}
	
	/**
	 * main method to init new instance
	 * @param args
	 */
	public static void main(String[] args) {
		StatesMap map = new StatesMap();
	}
}
