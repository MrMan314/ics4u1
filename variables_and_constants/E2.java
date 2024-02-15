import java.util.Scanner;

public class E2 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		float labourCost	= 0.75f;
		float rentCost		= 1.00f;
		System.out.print("Enter the diameter of the pizza in inches: ");
		float diameter		= inputReader.nextFloat();
		float materialsCost	= 0.05f * diameter * diameter;
		float totalCost		= labourCost + rentCost + materialsCost;
		System.out.printf("The cost of making pizza is: $%.2f\n", totalCost);
	}
}
