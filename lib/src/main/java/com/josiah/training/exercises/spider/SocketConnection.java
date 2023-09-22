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
		
		// try socket connection
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		try (
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
		
		setStringData(html.toString());
	}
	
	/**
	 * writes all pages in link tree from connection to their own html file
	 * @throws IOException
	 */
	public void writeAllPagesToFiles(String fileType) throws IOException {
		DataParser parser = new DataParser(stringData);
		parser.getRelativeLinks();
		Set<String> routes = parser.getRoutes();
		for(String route : routes) {
			System.out.println(route);
			SocketConnection fetcher = new SocketConnection(this.getHost(), this.getPortNumber(), route);
			String content = fetcher.getStringData();
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
