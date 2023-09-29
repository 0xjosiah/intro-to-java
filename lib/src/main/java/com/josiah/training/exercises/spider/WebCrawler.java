package com.josiah.training.exercises.spider;

import java.io.IOException;

/****************************************************************************
 * <b>Title:</b> Worker.java
 * <b>Project:</b> lib
 * <b>Description:</b> main class to crawl web page
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Sep 14, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class WebCrawler {
	
	/**
	 * web crawler
	 * @param args - expects host, port num, if print data to file(bool), file type
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// define args
//		String host = args[0];
//		int portNum = Integer.parseInt(args[1]);
//		String isPrintToFile = args[2];
//		String fileType = args[3];
//		String route = args[4];
//		String email = args[5];
//		String pw = args[6];
		
		String usr = System.getenv("SPIDER_USER");
		String pw = System.getenv("SPIDER_PW");
		
		SocketConnection fetcher = null;
		
		// init task
//		if(email != null & pw != null) {
//			fetcher = new SocketConnection(host, portNum, route, email, pw);
//		} else {
//			fetcher = new SocketConnection(host, portNum);			
//		}
		
		
		// allows for file printing
		// this is unnecessary in main 
//		String content = fetcher.getStringData();
		
//		if(isPrintToFile == "true") fetcher.writeAllPagesToFiles(fileType);
		
		// TODO: remove testing initialization 
		fetcher = new SocketConnection("smt-stage.qa.siliconmtn.com", 443, "admintool");
//		fetcher.writeAllPagesToFiles("html");
//		fetcher.connect();
//		fetcher.login(usr, pw);
//		fetcher.getStringData();
//		fetcher.closeConnection();
		
	}
}
