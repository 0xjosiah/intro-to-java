package com.josiah.training.exercises.serverConnector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
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
		try (Socket echoSocket = new Socket(this.host, this.portNumber)) {
			DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
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
	
	public static void main(String[] args) throws IOException {
		WebPageFetcher fetcher = new WebPageFetcher("127.0.0.1", 443);
		String content = fetcher.getWebPage();
		fetcher.printPageToConsole(content);
	}

}
