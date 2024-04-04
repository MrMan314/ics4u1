public class Food {

	private double price;
	private int fat, carb, fiber;

	String singularName, pluralName;

	public Food(double price, int fat, int carb, int fiber, String singularName, String pluralName) {
		this.price = price;
		this.fat = fat;
		this.carb = carb;
		this.fiber = fiber;
		this.singularName = singularName;
		this.pluralName = pluralName;
	}

	public double getPrice() {
		return price;
	}

	public int getFat() {
		return fat;
	}

	public int getCarb() {
		return carb;
	}

	public int getFiber() {
		return fiber;
	}

	public String getSingularName() {
		return singularName;
	}

	public String getPluralName() {
		return pluralName;
	}
}
