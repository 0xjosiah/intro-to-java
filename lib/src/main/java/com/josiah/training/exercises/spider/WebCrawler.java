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
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		ProcessWorker pw = new ProcessWorker();
		pw.run();
    }
}
