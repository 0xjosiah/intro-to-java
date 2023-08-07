package com.josiah.training.exercises.serverConnector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/****************************************************************************
 * <b>Title:</b> WebPageFetcher.java
 * <b>Project:</b> lib
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Aug 4, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class WebPageFetcher {
	// initialized private variables for constructor
	private String host = null;
	private int portNumber = 0;
	// static path to be used for testing
	private static final String PATH = "/home/josiah/dev/intro-to-java/lib/src/main/java/com/josiah/training/exercises/serverConnector/";
	
	
	/**
	 * constructor
	 * @param host
	 * @param portNumber
	 */
	public WebPageFetcher(String host, int portNumber) {
		this.host = host;
		this.portNumber = portNumber;
	}
	
	/**
	 * reaches out to a server socket, connects, and extracts html from page
	 * @param host
	 * @param portNumber
	 * @return
	 * @throws IOException
	 */
	public String getWebPage() throws IOException{
		// init string builder for ingested html
		StringBuilder html = new StringBuilder();
		
		// try socket connection
		try (
				Socket echoSocket = new Socket(this.host, this.portNumber);
				DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()))
			) {
			out.writeBytes("GET / HTTP/1.1\r\nHost: " + host + "\r\n\r\n");
			String inData = null;
			while((inData = in.readLine()) != null ) {
				html.append(inData);
			}
		} 
		
		catch (IOException e) {
		    System.out.println("Unable to connect to server: " + e.getMessage());
		}
		
		return html.toString();
	}
	
	
	/**
	 * prints fetched content
	 * @param content
	 */
	public void printPageToConsole(String content) {
		System.out.println(content);
	}
	
	/**
	 * takes in content, a destination file, and copies content to file
	 * @param content
	 * @param outputFile
	 */
	public void fileWriter(String content, String rootFolder, String outputFile) {
		String outputPath = rootFolder + File.separator + outputFile;
		// init output file
		File output = new File(outputPath);
		
		try {
			FileWriter writer = new FileWriter(output);
			writer.write(content);
			writer.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * calls constructor and tests with localhost default page
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		WebPageFetcher fetcher = new WebPageFetcher("127.0.0.1", 443);
		String content = fetcher.getWebPage();
		fetcher.printPageToConsole(content);
		fetcher.fileWriter(content, PATH, "output.txt");
	}

}
