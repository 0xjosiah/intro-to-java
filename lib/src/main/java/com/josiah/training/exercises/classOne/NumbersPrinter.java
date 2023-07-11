package com.josiah.training.exercises.classOne;

/****************************************************************************
 * <b>Title:</b> NumbersPrinter.java
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

public class NumbersPrinter {
	 /**
	  * Constructor
	  * @param args
	  */
	public static void main(String[] args) {
		NumbersPrinter printed = new NumbersPrinter();
		printed.printToTen();
		printed.printReverse();
		printed.printEvens();
	}
	
	/**
	 * method prints all ints 1-10
	 * @param n/a
	 * @return n/a
	 */
	public void printToTen() {
		// print method
		System.out.println("ints 1-10:");
		// init int var of one
		int i = 1;
		// while i is less than 11
		while(i < 11) {
			// if i is at end, print new line after i
			if(i == 10) {
				System.out.print(i + "\n");
			// else print i
			} else {
				System.out.print(i + ", ");	
			}
			// increment i
			i++;
		}
	}
	
	/**
	 * prints ints 1-10 in reverse order
	 * @param n/a
	 * @return n/a
	 */
	public void printReverse() {
		// print method description
		System.out.println("ints 10-1:");
		// loop thru nums from 10 to 1
		for (int i = 10; i > 0; i--) {
			// if i at end, print i and new line
			if(i == 1) System.out.print(i + "\n");
			// else print i with comma
			else System.out.print(i + ", ");
		}
	}
	
	/**
	 * prints evens to 20
	 * @param n/a
	 * @return
	 */
	public void printEvens() {
		// print method description
		System.out.println("even ints 1-20:");
		// loop thru ints 1-20
		for (int i = 1; i < 21; i++) {
			// if i modulo 2 equals 0
			if (i % 2 == 0) {
				// print i
				System.out.print(i + ", ");
			}
		}
	}
	

}
