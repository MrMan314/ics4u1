/*
 * Problem.java
 * Parent class of each question code
 */

import java.util.Scanner;

public abstract class Problem {
	// Scanner should only be accessed by child classes
	protected Scanner inputReader = new Scanner(System.in);
	
	// Fields for the problem
	private int problemNumber;
	private String problemName, problemDescription;

	// Set the fields on initialization
	public Problem(int number, String name, String description) {
		this.problemNumber = number;
		this.problemName = name;
		this.problemDescription = description;
	}

	/**
	 * Functions to get information about the problem
	 */
	public int getNumber() {
		return problemNumber;
	}

	public String getName() {
		return problemName;
	}

	public String getDescription() {
		return problemDescription;
	}

	/**
	 * A placeholder function that will be overrided by the child class
	 */
	abstract void run();
}
