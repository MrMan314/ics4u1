/*
 * Car.java
 * A car class, child of Vehicle
 */

public class Car extends Vehicle {
	private boolean running;

	/**
	 * Constructor for Car
	 * pre: none
	 * post: car vehicle created
	 */
	public Car() {
		super("car", 4, 2.0);
		running = false;
	}

	/**
	 * Honk function
	 * pre: none
	 * post: car honks
	 */
	public void honk() {
		System.out.println("Beep beep");
	}

	/**
	 * Accelerate function
	 * pre: none
	 * post: the car accelerates
	 */
	public void accelerate() {
		System.out.println("vrOOOOOOOOOOOOOOOoooom");
		running = true;
	}

	/**
	 * Stop function
	 * pre: none
	 * post: the car stops if it is still running
	 */
	public void stop() {
		if (running) {
			System.out.println("The car comes to a stop almost instantaneously.");
			running = false;
		} else {
			System.out.println("The car has already stopped.");
		}
	}
}
