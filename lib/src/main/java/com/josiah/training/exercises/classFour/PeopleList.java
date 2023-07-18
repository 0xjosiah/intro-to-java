package com.josiah.training.exercises.classFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
	ArrayList<Person> people = new ArrayList<Person>();
	
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
	
	public void shuffleList() {
		Collections.shuffle(people);
	}
	
	/**
	 * printer for list
	 */
	public void printList() {
		people.forEach(person -> System.out.println(person.toString()));
	}
	
	public static void main(String[] args) {
		PeopleList listOfPeople = new PeopleList();
		listOfPeople.printList();
		listOfPeople.shuffleList();
		listOfPeople.printList();
	}

}
