import java.util.Scanner;

public class E1 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter the number of copies to be printed: ");
		int copiesCount = inputReader.nextInt();
		inputReader.nextLine();
		float pricePerCopy = 0.25f;
		if (copiesCount < 100) {
			pricePerCopy = 0.30f;
		} else if (copiesCount < 500) {
			pricePerCopy = 0.28f;
		} else if (copiesCount < 750) {
			pricePerCopy = 0.27f;
		} else if (copiesCount < 1000) {
			pricePerCopy = 0.26f;
		}
		System.out.printf(
			"Price per copy is: $%.2f\n" +
			"Total cost is: $%.2f\n", pricePerCopy, (float)copiesCount * pricePerCopy);
	}
}
