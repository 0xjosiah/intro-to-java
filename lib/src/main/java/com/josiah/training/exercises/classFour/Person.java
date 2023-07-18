package com.josiah.training.exercises.classFour;

/****************************************************************************
 * <b>Title:</b> Person.java
 * <b>Project:</b> lib
 * <b>Description:</b> helper class used for PeopleList 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Josiah Webb
 * @version 3.x
 * @since Jul 18, 2023
 * <b>updates:</b>
 *  
 ****************************************************************************/

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	
	/**
	 * constructor 
	 * @param id
	 * @param first
	 * @param last
	 */
	public Person(int id, String first, String last) {
		this.id = id;
		this.firstName = first;
		this.lastName = last;
	}
	
	/**
	 * get person id
	 * @return id
	 */
	public int getPersonId() {
		return this.id;
	}
	
	/**
	 * get person's first name
	 * @return firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * get person's last name
	 * @return firstName
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	@Override
	public String toString() {
		return "id: " + this.id + ", first: " + this.firstName + ", last: " + this.lastName;
	}
}
