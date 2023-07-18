package com.josiah.training.exercises.classFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	/**
	 * main to convert string array to list
	 * @param args
	 */
	public static void main(String[] args) {
		// init string arr
	    String[] arr = {"one", "two"};
	
	    // create list var to store list from array
		List<String> list = new ArrayList<>(Arrays.asList(arr));
	
		System.out.println("Array elements: " + Arrays.toString(arr));
		System.out.println("List elements: " + list);
	}
}
