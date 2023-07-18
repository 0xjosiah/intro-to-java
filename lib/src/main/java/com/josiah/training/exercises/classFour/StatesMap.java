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
		ArrayList<String> keys = new ArrayList<String>(this.mapOfStates.keySet());
		// shuffle keys from map
		Collections.shuffle(keys);
		// loop thru keys
		for(Object stateKey : keys) {
			// put key-value pairs into temp map
			shuffled.put((String)stateKey, this.mapOfStates.get(stateKey));
		}
		// cast new map into existing mapOfStates, cast to ensure correct type
		return (HashMap<String, String>) (this.mapOfStates = shuffled);
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
		this.mapOfStates.put("AL", "Alabama");
		this.mapOfStates.put("AK", "Alaska");
		this.mapOfStates.put("AZ", "Arizona");
		this.mapOfStates.put("AR", "Arkansas");
		this.mapOfStates.put("CA", "California");
		this.mapOfStates.put("CO", "Colorado");
		this.mapOfStates.put("CT", "Connecticut");
		this.mapOfStates.put("DE", "Delaware");
		this.mapOfStates.put("FL", "Florida");
		this.mapOfStates.put("GA", "Georgia");
		this.mapOfStates.put("HI", "Hawaii");
		this.mapOfStates.put("ID", "Idaho");
		this.mapOfStates.put("IL", "Illinois");
		this.mapOfStates.put("IN", "Indiana");
		this.mapOfStates.put("IA", "Iowa");
		this.mapOfStates.put("KS", "Kansas");
		this.mapOfStates.put("KY", "Kentucky");
		this.mapOfStates.put("LA", "Louisiana");
		this.mapOfStates.put("ME", "Maine");
		this.mapOfStates.put("MD", "Maryland");
		this.mapOfStates.put("MA", "Massachusetts");
		this.mapOfStates.put("MI", "Michigan");
		this.mapOfStates.put("MN", "Minnesota");
		this.mapOfStates.put("MN", "Mississippi");
		this.mapOfStates.put("MO", "Missouri");
		this.mapOfStates.put("MT", "Montana");
		this.mapOfStates.put("NE", "Nebraska");
		this.mapOfStates.put("NV", "Nevada");
		this.mapOfStates.put("NH", "New Hampshire");
		this.mapOfStates.put("NJ", "New Jersey");
		this.mapOfStates.put("NM", "New Mexico");
		this.mapOfStates.put("NY", "New York");
		this.mapOfStates.put("NC", "North Carolina");
		this.mapOfStates.put("ND", "North Dakota");
		this.mapOfStates.put("OH", "Ohio");
		this.mapOfStates.put("OK", "Oklahoma");
		this.mapOfStates.put("OR", "Oregon");
		this.mapOfStates.put("PA", "Pennsylvania");
		this.mapOfStates.put("RI", "Rhode Island");
		this.mapOfStates.put("SC", "South Carolina");
		this.mapOfStates.put("SD", "South Dakota");
		this.mapOfStates.put("TN", "Tennessee");
		this.mapOfStates.put("TX", "Texas");
		this.mapOfStates.put("UT", "Utah");
		this.mapOfStates.put("VT", "Vermont");
		this.mapOfStates.put("VA", "Virginia");
		this.mapOfStates.put("WA", "Washington");
		this.mapOfStates.put("WV", "West Virginia");
		this.mapOfStates.put("WI", "Wisconsin");
		this.mapOfStates.put("WY", "Wyoming");
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
