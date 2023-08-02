package com.josiah.training.exercises.classThree;

import java.io.IOException;

/****************************************************************************
 * <b>Title:</b> CopyFileToUppercase.java
 * <b>Project:</b> lib
 * <b>Description:</b> takes in a file and makes a copy with all the characters in upper case
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jul 31, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/


public class CopyFileToUppercase {
	// static path to be used for testing
	public static final String PATH = "/home/josiah/dev/intro-to-java/lib/src/main/java/com/josiah/training/exercises/classThree/";
	
	/**
	 * invokes reader/writer and converts contents of source file to capitalized version in dest file
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileReaderWriter rw = new FileReaderWriter(PATH);
		String content = rw.fileReader("inputTest.txt");
		String capsContent = content.toUpperCase();
		rw.fileWriter(capsContent, "outputTest.txt");
	}
}
