/*
 * Vehicle.java
 * Abstract vehicle class used in classes Car, Minivan, and Truck
 */

public abstract class Vehicle {
	// Global variables
	private String vehicleType;
	private int wheelCount;
	private double mass;

	/**
	 * Constructor for vehicle
	 * pre: none
	 * post: Vehicle is created
	 */
	public Vehicle(String vehicleType, int wheelCount, double mass) {
		this.vehicleType = vehicleType;
		this.wheelCount = wheelCount;
		this.mass = mass;
	}

	// Abstract methods to be implemented in subclasses
	public abstract void honk();
	public abstract void accelerate();
	public abstract void stop();

	/**
	 * Returns the vehicle type
	 * pre: none
	 * post: The vehicle type is returned
	 */
	public String getType() {
		return vehicleType;
	}

	/**
	 * Returns the wheel count
	 * pre: none
	 * post: the wheel count is returned
	 */
	public int getWheelCount() {
		return wheelCount;
	}

	/**
	 * Returns the mass
	 * pre: none
	 * post: the mass is returned
	 */
	public double getMass() {
		return mass;
	}
}
