package com.josiah.training.exercises.spider;

import java.io.IOException;

/****************************************************************************
 * <b>Title:</b> Worker.java
 * <b>Project:</b> lib
 * <b>Description:</b> CHANGE ME!!
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
		String host = args[0];
		int portNum = Integer.parseInt(args[1]);
		String isPrintToFile = args[2];
		String fileType = args[3];
		
		SocketConnection fetcher = new SocketConnection(host, portNum);
		String content = fetcher.getStringData();
		DataParser parser = new DataParser(content);
		if(isPrintToFile == "true") fetcher.writeAllPagesToFiles(fileType);
	}
}
