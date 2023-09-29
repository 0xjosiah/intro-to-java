package com.josiah.training.exercises.spider;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/****************************************************************************
 * <b>Title:</b> SocketConnector.java
 * <b>Project:</b> lib
 * <b>Description:</b> class to connect to server over socket
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
	
	private String host;
	private int portNumber;
	private String route;
	private String stringData;
	private String email;
	private String password;
//	private SSLSocket socket;
	private Set<String> cookieSet = new HashSet<>();
	
	
	/**
	 * constructor
	 * @param host
	 * @param portNumber
	 * @throws IOException 
	 */
	public SocketConnection(String host, int portNumber) throws IOException {
		this.host = host;
		this.portNumber = portNumber;
//		connect();
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
//		connect();
	}
	
	/**
	 * constructor
	 * @param host
	 * @param portNumber
	 * @param route
	 * @param email
	 * @param password
	 * @throws IOException
	 */
	public SocketConnection(String host, int portNumber, String route, String email, String password) throws IOException {
		this.host = host;
		this.portNumber = portNumber;
		this.route = route;
		this.email = email;
		this.password = password;
//		connect();
	}
	
	/**
	 * reaches out to a server socket, connects, and extracts html from page
	 * @param host
	 * @param portNumber
	 * @return
	 * @throws IOException
	 */
	public void connRequest(String requestType, String postBody) throws IOException{
		// init string builder for ingested html
		StringBuilder html = new StringBuilder();
		// Create the socket factory
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

		try (SSLSocket socket = (SSLSocket) factory.createSocket(this.host, this.portNumber)) {
			BufferedOutputStream out = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()));
			// sets up request builder
			String request = requestBuilder(requestType, postBody);

			// write data to output stream and flush
			out.write(request.getBytes());
			out.flush();

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// init collector for data
			String inData;
			// collect data
			while((inData = in.readLine()) != null ) {
				html.append(inData);
				html.append(System.lineSeparator());

				if(inData.contains("Cookie")) cookies.add(inData + System.lineSeparator());
			}
		} 
		
		catch (IOException e) {
		    throw new IOException(e);
		}
		
		// set data to be stored in instance
		if(requestType.equals("GET")) setStringData(html.toString());
	}

	public String buildCookies() {
		StringBuilder cookies = new StringBuilder();
		for (String cookie : cookieSet) {
			String str = cookie.substring(12, cookie.indexOf(" ", 12));
			cookies.append(str);
		}
		return cookies.toString();
	}

	public String requestBuilder(String reqType, String postBody) {
		StringBuilder req = new StringBuilder();
		// ensure reqType formatting
		reqType = reqType.toUpperCase();

		// build request
		req.append(reqType).append(" /");
		// optional route for request
		if(route != null) request.append(route);

		// set host info
		req.append(" HTTP/1.1\r\nHost: ");
		req.append(host).append(System.lineSeparator());
		// if cookies, set cookie info
		if(!cookieSet.isEmpty()) {
			req.append("Cookie: ").append(buildCookies()).append(System.lineSeparator());
		}
		// if post body present, set body info
		if(!postBody.isEmpty()) {
			req.append("Content-Length: ").append(postBody.length()).append(System.lineSeparator());
			req.append("Content-Type: application/x-www-form-urlencoded")
					.append(System.lineSeparator()).append(System.lineSeparator());
			req.append(postBody).append(System.lineSeparator());
		}
		// add close request
		req.append("Connection: close");
		req.append(System.lineSeparator()).append(System.lineSeparator());

		// returns string
		return req.toString();
	}
	

    public void closeConnection() {
        if (socket != null && !socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
    }
	
	public void login() throws IOException{
		// sets up post request to login at designated url
		StringBuilder requestBody = new StringBuilder();
		StringBuilder requestHeader = new StringBuilder();
		StringBuilder request = new StringBuilder();
		
		requestBody.append("requestType=");
		requestBody.append(URLEncoder.encode("reqBuild", "UTF-8"));
		requestBody.append("&pmid=");
		requestBody.append(URLEncoder.encode("ADMIN_LOGIN", "UTF-8"));
		requestBody.append("&emailAddress=");
		requestBody.append(URLEncoder.encode(email, "UTF-8"));
		requestBody.append("&password=");
		requestBody.append(URLEncoder.encode(password, "UTF-8"));
		requestBody.append("&l=");
		requestBody.append(URLEncoder.encode("", "UTF-8"));
//				 +  +
//				 +  +
//				 +  +
//				 + ;
		
//		String requestHeaders = "POST " + url.getFile() + " HTTP/1.1\r\n" +
//				"Host: " + url.getHost() + "\r\n" +
//				"Content-Length: " + postRequestBody.length() + "\r\n" +
//				"Content-Type: application/x-www-form-urlencoded\r\n" +
//				"\r\n" + postRequestBody + "\r\n" +
//				"Connection: close\r\n\r\n";
		requestHeader.append("POST /");
		// optional route for request
		if(route != null) request.append(route);
		
		requestHeader.append(" HTTP/1.1\r\nHost: ");
		requestHeader.append(host);
		requestHeader.append(System.lineSeparator());
		requestHeader.append("Connection: close\r\n\r\n");
		requestHeader.append(System.lineSeparator()); 
	}
	
	public void login(String username, String password) throws IOException {
	    // Ensure you have already connected using the connect() method.
		
	    
	    // Construct the login POST request
	    StringBuilder loginRequest = new StringBuilder();
	    loginRequest.append("POST /login HTTP/1.1\r\n");
	    loginRequest.append("Host: ").append(host).append("\r\n");
	    loginRequest.append("Content-Type: application/x-www-form-urlencoded\r\n");
	    loginRequest.append("Content-Length: ").append(username.length() + password.length() + 11).append("\r\n");
	    loginRequest.append("Connection: close\r\n\r\n");
	    loginRequest.append("username=").append(URLEncoder.encode(username, "UTF-8"));
	    loginRequest.append("&password=").append(URLEncoder.encode(password, "UTF-8"));

	    // Get the output stream and send the login request
	    try (BufferedOutputStream out = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()))) {
	        out.write(loginRequest.toString().getBytes());
	        out.flush();
	    }

	    // You may want to read and process the response to verify successful login or handle any errors.
	    // You can do this by reading from the input stream in the same way as in your connect() method.
	    // It's important to parse and handle the server's response accordingly.
	    // For example, you might check for a successful login message or an error message in the HTML response.

	    // After successfully logging in, you can continue using the existing connection to interact with the website.
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
			// checks for home or / route
			if(route.isEmpty()) {
				creator.filePrinter("home", content);
			} else {
				creator.filePrinter(route, content);				
			}
		}
	}
	
	/**
	 * Getters and Setters for all instance vars
	 */
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
