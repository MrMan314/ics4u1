/*
 * E3.java
 * Exercise 3 - Vehicles
 */

import java.util.ArrayList;

public class E3 extends Problem {
	// ArrayList to store accounts
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	/**
	 * Constructor
	 * pre: none
	 * post: E2 problem created
	 */
	public E3() {
		super(3, "Vehicle", "Simulates vehicles");
	}

	/**
	 * Function to run for problem
	 * pre: none
	 * post: account problem run
	 */
	public void run() {
		// Loop until user exits
		boolean running = true;
		while (running) {
			// Prompt user for input
			System.out.print(
				"Please select the action you want to perform:\n" +
				"\t1. LIST vehicles\n" +
				"\t2. SELECT vehicle\n" +
				"\t3. REMOVE vehicle\n" +
				"\t4. CREATE vehicle\n" +
				"Enter your choice, or type 'quit' to quit > "
			);
			String option = super.inputReader.nextLine().toUpperCase().strip();
			// Run function based on input
			switch(option) {
				case "1":
				case "LIST":
					listVehicles();
					break;
				case "2":
				case "SELECT":
					selectVehicle();
					break;
				case "3":
				case "REMOVE":
					removeVehicle();
					break;
				case "4":
				case "CREATE":
					createVehicle();
					break;
				case "QUIT":
					running = false;
					break;
				default:
					System.out.println("Sorry, I don't know what you mean!");
			}
		}
	}

	/**
	 * Lists the vehicles stored in the ArrayList
	 * pre: none
	 * post: the information of the vehicles are displayed to the user
	 */
	private void listVehicles() {
		// Print a "header" for the list
		System.out.printf(
			"There are currently %d vehicles:\n" +
			"Index\tType\tWheels\tMass\n", 
			vehicles.size()
		);
		// Iterate over the list and print out its information
		for(int i = 0; i < vehicles.size(); i++) {
			Vehicle vehicle = vehicles.get(i);
			System.out.printf("%d:\t%s\t%d\t%.1f T\n", i, vehicle.getType(), vehicle.getWheelCount(), vehicle.getMass());
		}
	}

	/**
	 * Selects a vehicle and perfroms actions on it
	 * pre: none
	 * post: necessary actions performed on vehicle
	 */
	private void selectVehicle() {
		// Show user a list of the vehicles
		listVehicles();
		// Prompt user for input
		System.out.print("Please enter the index of the vehicle you want to perform operations on\n > ");
		int vehicleSelection = super.inputReader.nextInt();
		super.inputReader.nextLine();
		// Check if input is out of range, exit if so
		if(vehicleSelection < 0 || vehicleSelection >= vehicles.size()) {
			System.out.println("The index is out of range.");
			return;
		}

		// Run until user says not to
		boolean running = true;

		while (running) {
			// Promptu user for input
			System.out.print(
				"Please select the action you want to perform:\n" +
				"\t1. Honk\n" +
				"\t2. Accelerate\n" +
				"\t3. Stop\n" +
				"Enter your choice, or type 'quit' to quit > "
			);
			String option = super.inputReader.nextLine().toUpperCase().strip();

			// Run function based on user input
			switch (option) {
				case "1":
				case "H":
				case "HONK":
					vehicles.get(vehicleSelection).honk();
					break;
				case "2":
				case "A":
				case "ACCELERATE":
					vehicles.get(vehicleSelection).accelerate();
					break;
				case "3":
				case "S":
				case "STOP":
					vehicles.get(vehicleSelection).stop();
					break;
				case "QUIT":
					running = false;
					break;
				default:
					System.out.println("That is not a valid option.");
			}
		}
	}

	/**
	 * Removes a vehicle from the ArrayList
	 * pre: none
	 * post: vehicle is removed if input is valid
	 */
	private void removeVehicle() {
		// Show user a list of vehicles
		listVehicles();
		// Prompt user for input
		System.out.print("Please enter the index of the vehicle you want to delete\n > ");
		int vehicleDeletion = super.inputReader.nextInt();
		super.inputReader.nextLine();
		// Check if input is out of range, if so, exit
		if(vehicleDeletion < 0 || vehicleDeletion >= vehicles.size()) {
			System.out.println("The index is out of range.");
			return;
		}
		// Delete vehicle if input is in range
		vehicles.remove(vehicleDeletion);
		// Tell user about the deletion
		System.out.printf("The vehicle with index %d has been deleted.\n", vehicleDeletion);
	}

	/**
	 * Creates a vehicle
	 * pre: none
	 * post: vehicle is created
	 */
	private void createVehicle() {
		// Prompt user for input
		System.out.print(
			"Please select the type of vehicle you wish to create:\n" +
			"\t1. Car\n" +
			"\t2. Truck\n" +
			"\t3. Minivan\n" +
			" > "
		);
		String vehicleType = super.inputReader.nextLine().toUpperCase().strip();
		// Create new vehicle based on input
		switch (vehicleType) {
			case "1":
			case "C":
			case "CAR":
				vehicles.add(new Car());
				break;
			case "2":
			case "T":
			case "TRUCK":
				vehicles.add(new Truck());
				break;
			case "3":
			case "M":
			case "MINIVAN":
				vehicles.add(new Minivan());
				break;
			default:
				// Exit if vehicle type is invalid
				System.out.println("Sorry, you have entered an invalid vehicle type.");
				return;
		}
		// Inform user about the creation
		System.out.printf("New vehicle created with index %d.\n", vehicles.size() - 1);
	}
}
