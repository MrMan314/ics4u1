/**
 * E3.java
 * Lesson 8 - OOP
 * Exercise 3  - Lunch Order
 */

public class L8E3 extends Problem {

	// Constructor to initialize fields in parent class
	public L8E3() {
		super(8, 3, "Lunch Order", "Prompts the user to order food, displaying the food's information");
	}

	/**
	 * Main function run from outside
	 */
	@Override
	public void run() {
		// Create a new array of the foods and their information
		Food foods[] = {
			new Food(1.85,  9, 33, 1, "hamburger", "hamburgers"),
			new Food(2.00,  1, 11, 5, "salad", "salads"),
			new Food(1.30, 11, 36, 4, "french fries", "french fries"),
			new Food(0.95,  0, 38, 0, "soda", "sodas"),
		};

		// Create a running total
		double total = 0;

		// Loop for each food
		for (Food food: foods) {
			// Display information of food
			System.out.printf(
				"Each %s costs $%.2f, has %dg of fat, %dg of carbs, and %dg of fiber.\n" +
				"Please enter number of %s: ",
				food.getSingularName(), food.getPrice(), food.getFat(), food.getCarb(), food.getFiber(),
				food.getPluralName()
			);
			// Get the user input on the quantity of food
			int quantity = super.inputReader.nextInt();
			super.inputReader.nextLine();
			// Add price to running total
			total += food.getPrice() * (double) quantity;
		}
		// Output the final price
		System.out.printf("Your order comes to: $%.2f.\n", total);
	}
}
