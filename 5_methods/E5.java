import java.util.Scanner;

public class E5 extends Problem {
	private static int problemNumber = 5;
	private static String problemName = "Get Dollar Amount";
	private static String problemDescription = "Displays the total dollar amount when given a number of quarters, dimes, nickels, and pennies.";
	
	private static Scanner inputReader = new Scanner(System.in);

	public E5() {
		super.problemNumber = this.problemNumber;
		super.problemName = this.problemName;
		super.problemDescription = this.problemDescription;
	}

	private static double getDollarAmount(int quarters, int dimes, int nickels, int pennies) {
		return quarters * 0.25 + dimes * 0.10 + nickels * 0.05 + pennies * 0.01;
	}

	@Override
	public void main(String[] args) {
		System.out.print(
			"Enter your total coins:\n\n" +
			"Quarters: "
		);
		int quarters = inputReader.nextInt();
		inputReader.nextLine();

		System.out.print("Dimes: ");
		int dimes = inputReader.nextInt();
		inputReader.nextLine();

		System.out.print("Nickels: ");
		int nickels = inputReader.nextInt();
		inputReader.nextLine();

		System.out.print("Pennies: ");
		int pennies = inputReader.nextInt();
		inputReader.nextLine();

		System.out.printf("\nTotal: $%.2f\n", getDollarAmount(quarters, dimes, nickels, pennies));
	}
}
