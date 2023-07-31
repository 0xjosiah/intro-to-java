package com.josiah.training.exercises.classThree;
import java.io.*;

/****************************************************************************
 * <b>Title:</b> FileCopier.java
 * <b>Project:</b> lib
 * <b>Description:</b> takes in a root folder, reads in a file and writes to a new file
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jul 31, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class FileCopier {
	// init private var for file path
	private String rootFolder;
	// path for test file
//	 /home/josiah/dev/intro-to-java/lib/src/main/java/com/josiah/training/exercises/classThree/inputTest.txt

	/**
	 * Constructor - takes in root folder and assigns to private var
	 * @param rootFolder
	 */
	public FileCopier(String rootFolder) {
		this.rootFolder = rootFolder;
	}
	
	/**
	 * file reader method
	 * @return string of read file content
	 * @throws IOException
	 */
	public String FileReader() throws IOException {
		// init new file
		File inputFile = new File(rootFolder);
		// init string builder for content
		StringBuilder content = new StringBuilder();
		// try block
		try {
			// init reader
			FileReader reader = new FileReader(inputFile);
			// init counter for reader
			int c;
			// loop thru and extract content
			while((c = reader.read()) != -1) {
				content.append((char) c);
			}
			// close reader
			reader.close();
		} catch(Exception e) {
			System.out.println(e);
		}

		return content.toString();
	}
}
