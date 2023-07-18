package com.josiah.training.exercises.classFour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
	
	/**
	 * constructor calls loadMap to populate map
	 */
	public StatesMap() {
		loadMap();
	}
	
	/**
	 * sorts states map by key
	 * @return mapOfStates
	 */
	public TreeMap<String, String> sortMap() {
		// init new tree map for sorting by key, pass in current mapOfStates
		TreeMap<String, String> sortedStatesMap = new TreeMap<String, String>(this.mapOfStates);
		// return cast to tree map
		return (TreeMap<String, String>) (this.mapOfStates = sortedStatesMap);
	}
	
	/**
	 * method to shuffle map of states
	 * @return mapOfStates
	 */
	public HashMap<String, String> shuffleMap() {
		// init temp to store sorted map
		HashMap<String, String> shuffled = new HashMap<String, String>();
		// create list to get keys from existing map
		ArrayList<String> keys = new ArrayList<String>(mapOfStates.keySet());
		// shuffle keys from map
		Collections.shuffle(keys);
		// loop thru keys
		for(Object stateKey : keys) {
			// put key-value pairs into temp map
			shuffled.put((String)stateKey, mapOfStates.get(stateKey));
		}
		// cast new map into existing mapOfStates, cast to ensure correct type
		return (HashMap<String, String>) (mapOfStates = shuffled);
	}
	
	/**
	 * helper method to print existing state of map
	 */
	public void printMap() {
		// prints for each key, value pair
		this.mapOfStates.forEach((key, value) -> System.out.println(key + ":" + value));
	}
	
	/**
	 * method loads map of states
	 */
	protected void loadMap() {
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
		mapOfStates.put("MT", "Montana");
		mapOfStates.put("NE", "Nebraska");
		mapOfStates.put("NV", "Nevada");
		mapOfStates.put("NH", "New Hampshire");
		mapOfStates.put("NJ", "New Jersey");
		mapOfStates.put("NM", "New Mexico");
		mapOfStates.put("NY", "New York");
		mapOfStates.put("NC", "North Carolina");
		mapOfStates.put("ND", "North Dakota");
		mapOfStates.put("OH", "Ohio");
		mapOfStates.put("OK", "Oklahoma");
		mapOfStates.put("OR", "Oregon");
		mapOfStates.put("PA", "Pennsylvania");
		mapOfStates.put("RI", "Rhode Island");
		mapOfStates.put("SC", "South Carolina");
		mapOfStates.put("SD", "South Dakota");
		mapOfStates.put("TN", "Tennessee");
		mapOfStates.put("TX", "Texas");
		mapOfStates.put("UT", "Utah");
		mapOfStates.put("VT", "Vermont");
		mapOfStates.put("VA", "Virginia");
		mapOfStates.put("WA", "Washington");
		mapOfStates.put("WV", "West Virginia");
		mapOfStates.put("WI", "Wisconsin");
		mapOfStates.put("WY", "Wyoming");
	}
	
	/**
	 * main method to init new instance
	 * @param args
	 */
	public static void main(String[] args) {
		StatesMap map = new StatesMap();
		map.sortMap();
		map.printMap();
		map.shuffleMap();
		map.printMap();
	}
}
