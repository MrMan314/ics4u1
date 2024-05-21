import java.util.Scanner;
import java.util.Random;

public class E9 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		Random randomGenerator = new Random();
		System.out.print("Enter a number between 1 and 20: ");
		int guessedNumber = inputReader.nextInt();
		inputReader.nextLine();
		int generatedNumber = randomGenerator.nextInt(20) + 1;
		System.out.printf(
			"Computer's Number: %d\n" +
			"Player's Number: %d\n",
			generatedNumber, guessedNumber);
		if (generatedNumber == guessedNumber) {
			System.out.println("You won!");
		} else {
			System.out.println("Better luck next time.");
		}
	}
}
