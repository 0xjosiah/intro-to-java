package com.josiah.training.exercises.spider;

import java.io.IOException;
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
	
	public Set<String> getRoutes() {
		return this.routes;
	}
	
	public void getRelativeLinks() {
		Elements links = document.select("a[href*=/]");
		
		
//		Set<Element> linkSet = new HashSet<Element>();
		
//		System.out.println(links);
		
		for(Element e : links) {
//			System.out.println(e.attributes());
			String href = e.attributes().toString();
			href = href.replaceAll("href=\"/|\"", "");
//			String uri = e.baseUri();
//			if(!linkSet.add(uri)) linkSet.add(uri);
			if(!routes.add(href)) {
				routes.add(href);
				
			}
		}
		System.out.println(routes);
	}
//		return linkSet;
}
