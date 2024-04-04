public class E3 extends Problem {

	public E3() {
		super(3, "Lunch Order", "test2");
	}

	@Override
	public void run() {
		Food foods[] = {
			new Food(1.85,  9, 33, 1, "hamburger", "hamburgers"),
			new Food(2.00,  1, 11, 5, "salad", "salads"),
			new Food(1.30, 11, 36, 4, "french fries", "french fries"),
			new Food(0.95,  0, 38, 0, "soda", "sodas"),
		};

		for (Food food: foods) {
			System.out.printf(
				"Each %s costs %.2f, has %dg of fat, %dg of carbs, and %dg of fiber.\n" +
				"Please enter number of %s: ",
				food.getSingularName(), food.getPrice(), food.getFat(), food.getCarb(), food.getFiber(),
				food.getPluralName()
			);
		}
	}
}
