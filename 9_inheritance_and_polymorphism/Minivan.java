/*
 * Minivan.java
 * A minivan class, child of vehicle
 */

public class Minivan extends Vehicle {
	private bool running;

	/**
	 * Constructor for minivan
	 * pre: none
	 * post: minivan vehicle created
	 */
	public Minivan() {
		super("minivan", 4, 2.5);
		running = false;
	}

	/**
	 * Honk function
	 * pre: none
	 * post: minivan honks
	 */
	public void honk() {
		System.out.println("Beep beep!");
	}

	/**
	 * Accelerate function
	 * pre: none
	 * post: minivan accelerates
	 */
	public void accelerate() {
		System.out.println("Vrooom");
		running = true;
	}

	/**
	 * Stop function
	 * pre: none
	 * post: minivan stops if it is still running
	 */
	public void stop() {
		if (running) {
			System.out.println("The minivan comes to a stop almost instantaneously");
			running = false;
		} else {
			System.out.println("The minivan has already stopped");
		}
	}
}
