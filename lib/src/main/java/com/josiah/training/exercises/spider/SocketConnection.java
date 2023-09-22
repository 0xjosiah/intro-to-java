package com.josiah.training.exercises.spider;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

//import javax.lang.model.util.Elements;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/****************************************************************************
 * <b>Title:</b> SocketConnector.java
 * <b>Project:</b> lib
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Sep 20, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class SocketConnection {
	// initialized private variables for constructor
	private String host = null;
	private int portNumber = 0;
	private String route = null;
	private String stringData = null;
	// static path to be used for testing
	private static final String PATH = "/home/josiah/dev/intro-to-java/lib/src/main/java/com/josiah/training/exercises/spider/";
	
	
	/**
	 * constructor
	 * @param host
	 * @param portNumber
	 * @throws IOException 
	 */
	public SocketConnection(String host, int portNumber) throws IOException {
		this.host = host;
		this.portNumber = portNumber;
		connect();
	}
	
	/**
	 * constructor 
	 * @param host
	 * @param portNumber
	 * @param route (excluding any "/")
	 * @throws IOException 
	 */
	public SocketConnection(String host, int portNumber, String route) throws IOException {
		this.host = host;
		this.portNumber = portNumber;
		this.route = route;
		connect();
	}
	
	/**
	 * reaches out to a server socket, connects, and extracts html from page
	 * @param host
	 * @param portNumber
	 * @return
	 * @throws IOException
	 */
	public void connect() throws IOException{
		// init string builder for ingested html
		StringBuilder html = new StringBuilder();
		
		// try socket connection
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		try (
//				Socket echoSocket = new Socket(this.host, this.portNumber);
		        SSLSocket socket = (SSLSocket) factory.createSocket(host, portNumber);
				BufferedOutputStream out = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()));
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			) {
			StringBuilder request = new StringBuilder();
			request.append("GET /");
			if(route != null) request.append(route);
			request.append(" HTTP/1.1\r\nHost: ");
			request.append(host);
			request.append(System.lineSeparator());
			request.append("Connection: close\r\n\r\n");
			request.append(System.lineSeparator());
//			System.out.println(request.toString());
			out.write(request.toString().getBytes());
			out.flush();
			String inData = null;
			while((inData = in.readLine()) != null ) {
				html.append(inData);
			}
		} 
		
		catch (IOException e) {
		    System.out.println("Unable to connect to server: " + e.getMessage());
		}
		
		this.stringData = html.toString();
	}
	
	/**
	 * getter for string data of connected socket
	 * @return stringData
	 */
	public String getStringData() {
		return this.stringData;
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
		SocketConnection fetcher = new SocketConnection("smt-stage.qa.siliconmtn.com", 443);
		String content = fetcher.getStringData();
		DataParser parser = new DataParser(content);
		parser.getRelativeLinks();
//		fetcher.printPageToConsole(content);
//		
//		Document doc = Jsoup.parse(content);
////		System.out.println(doc);
//		Elements links = doc.select("a[href*=/]");
////		Set<Element> linkSet = new HashSet<Element>();
//		Set<String> linkSet = new HashSet<>();
////		System.out.println(links);
//		
//		for(Element e : links) {
////			System.out.println(e.attributes());
//			String href = e.attributes().toString();
////			String uri = e.baseUri();
////			if(!linkSet.add(uri)) linkSet.add(uri);
//			if(!linkSet.add(href)) linkSet.add(href);
//		}
//		System.out.println(linkSet);
		fetcher.fileWriter(content, PATH, "output.txt");
	}

}
