package com.josiah.training.exercises.classTwo;

/****************************************************************************
 * <b>Title:</b> ArrayExercise.java
 * <b>Project:</b> lib
 * <b>Description:</b> exercise from intro to programming class 2
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jun 12, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class ArrayExercise {
	// init empty int array
	private int[] nums;
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayExercise arr = new ArrayExercise();
		arr.fillArray();
		arr.printArray();
	}
	
	/**
	 * constructor
	 */
	public ArrayExercise() {
		this.nums = new int[10];
	}
	
	/**
	 * fills array with random numbers
	 */
	public void fillArray() {
		// loop thru array length
		for(int i = 0; i < nums.length; i++) {
			// assign random int to var
			int randVal = (int) (Math.random() * 100);
			// assign var to index of array
			nums[i] = randVal;
		}
	}
	
	/**
	 * prints array
	 */
	public void printArray() {
		// loop thru array
		for(int i = 0; i < nums.length; i++) {
			// print value at index and index num
			System.out.println(nums[i] + " at index " + i);
		}
	}
}
