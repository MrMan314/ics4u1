import java.util.Scanner;

public class E11 {
	public static void main(String[] args) {
		float burgerCost	= 1.69f;
		float friesCost		= 1.09f;
		float sodaCost		= 0.99f;
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter the number of burgers: ");
		int burgerCount = inputReader.nextInt();
		System.out.print("Enter the number of fries: ");
		int friesCount = inputReader.nextInt();
		System.out.print("Enter the number of sodas: ");
		int sodaCount = inputReader.nextInt();
		
		float totalBeforeTax = burgerCount * burgerCost + friesCount * friesCost + sodaCount * sodaCost;
		float tax = totalBeforeTax * 0.065f;
		float finalTotal = totalBeforeTax + tax;
		System.out.printf(
			"Total before tax: $%.2f\n" +
			"Tax: $%.2f\n" + 
			"Final total: $%.2f\n\n",
			totalBeforeTax, tax, finalTotal);
		
		System.out.print("Enter amount tendered: $");
		float amountTendered = inputReader.nextFloat();
		float change = amountTendered - finalTotal;
		
		System.out.printf("Change: $%.2f\n", change);
	}
}
