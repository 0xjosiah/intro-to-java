package com.josiah.training.exercises.spider;

import java.io.File;
import java.io.FileWriter;
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
	private String type = null;
	
	/**
	 * constructor
	 * @param type
	 */
	public CreateFile(String type) {
		this.type = type;
	}
	
	/**
	 * creates and fills file with given params
	 * @param filename
	 * @param content
	 * @throws IOException
	 */
	public void filePrinter(String filename, String content) throws IOException {
		File outFile = new File(filename + "." + this.type);
		try ( FileWriter writer = new FileWriter(outFile)) {
			writer.write(content);
		}
	}
}
