package com.josiah.training.exercises.spider;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/****************************************************************************
 * <b>Title:</b> DataParser.java
 * <b>Project:</b> lib
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Sep 22, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class DataParser {
	private String content = null;
	private Document document = null;
	private Set<String> routes = new HashSet<>();
	
	/**
	 * constructor
	 * @param content
	 */
	public DataParser(String content) {
		this.content = content;
		this.document = Jsoup.parse(content);
	}
	
	/**
	 * getter for content
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * getter for routes
	 * @return set of routes as strings
	 */
	public Set<String> getRoutes() {
		return this.routes;
	}
	
	/**
	 * populates data for relative links on page
	 */
	public void getRelativeLinks() {
		Elements links = document.select("a[href*=/]");
		
		for(Element e : links) {
			// gets the href of element, converts to string
			String href = e.attributes().toString();
			// reduces to just the name of the route
			href = href.replaceAll("href=\"/|\"", "");
			// trims white space
			href = href.trim();
			// adds route to data store
			if(!routes.add(href)) routes.add(href);
		}
	}
}
