package com.josiah.training.exercises.classFour;

import java.util.ArrayList;
import java.util.Arrays;

/****************************************************************************
 * <b>Title:</b> StringArrayToListConverter.java
 * <b>Project:</b> lib
 * <b>Description:</b> exercise three from class four of dev training.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jul 14, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class StringArrayToListConverter {
	// init list to store converted array
	ArrayList<String> stringList = new ArrayList<String>();
	
	/**
	 * constructor 
	 * @param strings
	 */
	public StringArrayToListConverter(String[] strings) {
		this.stringList = (ArrayList<String>) Arrays.asList(strings);
	}
	
	/**
	 * get the converted list
	 * @return stringList
	 */
	public ArrayList<String> getList() {
		return this.stringList;
	}
}
