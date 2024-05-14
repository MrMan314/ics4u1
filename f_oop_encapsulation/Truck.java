/*
 * Truck.java
 * A truck class, child of vehicle
 */

public class Truck extends Vehicle {
	private boolean running;

	/**
	 * Constructor for truck
	 * pre: none
	 * post: truck vehicle created
	 */
	public Truck() {
		super("truck", 18, 25.0);
		running = false;
	}

	/**
	 * Honk function
	 * pre: none
	 * post: truck honks
	 */
	public void honk() {
		System.out.println("BEEEEEEEEEEEEEEEEEEEEEEEP (your eardrums rupture)");
	}

	/**
	 * Accelerate function
	 * pre: none
	 * post: the truck accelerates
	 */
	public void accelerate() {
		System.out.println("Vroom");
		running = true;
	}

	/**
	 * Stop function
	 * pre: none
	 * post: the truck tries to stop if it is still running
	 */
	public void stop() {
		if (running) {
			System.out.println("The truck slows down and comes to a stop after a few meters.");
			running = false;
		} else {
			System.out.println("The truck has already stopped");
		}
	}
}
