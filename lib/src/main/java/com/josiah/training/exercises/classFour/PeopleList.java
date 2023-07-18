package com.josiah.training.exercises.classFour;

import java.util.ArrayList;

/****************************************************************************
 * <b>Title:</b> PeopleList.java
 * <b>Project:</b> lib
 * <b>Description:</b> exercise two from class four of dev training.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jul 14, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class PeopleList {
	// init list to hold people
	ArrayList<Object> people = new ArrayList<Object>();
	
	/**
	 * constructor calls load list
	 */
	public PeopleList() {
		loadList();
	}
	
	/**
	 * fills people list
	 */
	protected void loadList() {
		people.add(new Person(1, "Luke", "Skywalker"));
		people.add(new Person(2, "Darth", "Vader"));
		people.add(new Person(3, "Han", "Solo"));
		people.add(new Person(4, "Leia", "Organa"));
	}
	
	
	
	

}
