package com.josiah.training.exercises.spider;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

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
	
	private String host = null;
	private int portNumber = 0;
	private String route = null;
	private String stringData = null;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
	public String getStringData() {
		return this.stringData;
	}
	
	public void setStringData(String content) {
		this.stringData = content;
	}
	
	
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

		// creates ssl socket factory
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		// try socket connection
		try (
		        SSLSocket socket = (SSLSocket) factory.createSocket(host, portNumber);
				BufferedOutputStream out = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()));
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			) {
				// sets up request builder
				StringBuilder request = new StringBuilder();
				
				// build request
				request.append("GET /");
				// optional route for request
				if(route != null) request.append(route);
				
				request.append(" HTTP/1.1\r\nHost: ");
				request.append(host);
				request.append(System.lineSeparator());
				request.append("Connection: close\r\n\r\n");
				request.append(System.lineSeparator());
				
				// write data to output stream and flush
				out.write(request.toString().getBytes());
				out.flush();
				
				// init collector for data
				String inData = null;
				// collect data
				while((inData = in.readLine()) != null ) {
					html.append(inData);
				}
		} 
		
		catch (IOException e) {
		    System.out.println("Unable to connect to server: " + e.getMessage());
		}
		
		// set data to be stored in instance
		setStringData(html.toString());
	}
	
	/**
	 * writes all pages in link tree from connection to their own html file
	 * @throws IOException
	 */
	public void writeAllPagesToFiles(String fileType) throws IOException {
		// creates new parser with instance string data
		DataParser parser = new DataParser(stringData);
		// gets relative links for parser to use
		parser.getRelativeLinks();
		// collects routes from parser
		Set<String> routes = parser.getRoutes();
		
		for(String route : routes) {
			// creates new fetcher for each route
			SocketConnection fetcher = new SocketConnection(this.getHost(), this.getPortNumber(), route);
			// gets content of route
			String content = fetcher.getStringData();
			// creates and prints file for each route
			CreateFile creator = new CreateFile(fileType);
			creator.filePrinter(route, content);
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
		fetcher.writeAllPagesToFiles("html");
//		parser.getRelativeLinks();
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
	}

}
