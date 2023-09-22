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
	
	public DataParser(String content) {
		this.content = content;
	}
	
	public static void main(String[] args) throws IOException {
	
	SocketConnection fetcher = new SocketConnection("smt-stage.qa.siliconmtn.com", 443);
	String content = fetcher.getStringData();
//	fetcher.printPageToConsole(content);
	
	Document doc = Jsoup.parse(content);
//	System.out.println(doc);
	Elements links = doc.select("a[href*=/]");
//	Set<Element> linkSet = new HashSet<Element>();
	Set<String> linkSet = new HashSet<>();
//	System.out.println(links);
	
	for(Element e : links) {
//		System.out.println(e.attributes());
		String href = e.attributes().toString();
//		String uri = e.baseUri();
//		if(!linkSet.add(uri)) linkSet.add(uri);
		if(!linkSet.add(href)) linkSet.add(href);
	}
	System.out.println(linkSet);
	}
}
