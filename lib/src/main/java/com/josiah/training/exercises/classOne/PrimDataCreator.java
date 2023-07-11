package com.josiah.training.exercises;

/****************************************************************************
 * <b>Title:</b> PrimDataCreator.java
 * <b>Project:</b> lib
 * <b>Description:</b> exercise from intro to java class 1
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jun 9, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class PrimDataCreator {
	// create private vars for each primitive
	private int integerValue = 2;
	private double doubleValue = 5.99028;
	private float floatValue = 0.8375F;
	private char charValue = 'f';
	private boolean boolValue = true;
	
	/**
	 * Prints all data types to console
	 * @param n/a
	 * @return n/a
	 */
	public void printDataTypes() {
		// print each var with type
		System.out.println("integer value " + integerValue);
		System.out.println("double value " + doubleValue);
		System.out.println("float value " + floatValue);
		System.out.println("char value " + charValue);
		System.out.println("boolean value " + boolValue);
	}
	
	/**
	 * inits class and stores primitive data types
	 * @param n/a
	 * @return n/a
	 */
//	public static void main(String[] args) {
//		PrimDataCreator primitives = new PrimDataCreator();
//		primitives.printDataTypes();
//	}
}
