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
	public static void main(String[] args) throws IOException {
		SocketConnection fetcher = new SocketConnection("smt-stage.qa.siliconmtn.com", 443);
		String content = fetcher.getStringData();
		DataParser parser = new DataParser(content);
		fetcher.writeAllPagesToFiles("html");
	}
}
