package com.josiah.training.exercises.spider;

import java.io.File;
import java.io.IOException;

/****************************************************************************
 * <b>Title:</b> CreateFile.java
 * <b>Project:</b> intro-to-java
 * <b>Description:</b> creates a file in the relative directory
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Sep 21, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class CreateFile {
	
	public void filePrinter(Set<String> routes) {
		
	}
	public static void main(String[] args) {
	    try {
	      File myObj = new File("filename.txt");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
