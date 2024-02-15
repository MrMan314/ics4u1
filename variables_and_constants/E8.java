import java.util.Scanner;

public class E8 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int firstNumber = inputReader.nextInt();
		System.out.print("Enter a second integer: ");
		int secondNumber = inputReader.nextInt();
		System.out.printf(
			"\n%d / %d = %d\n" + 
			"%d %% %d = %d\n\n" +
			"%d / %d = %d\n" +
			"%d %% %d = %d\n",
			firstNumber, secondNumber, firstNumber / secondNumber,
			firstNumber, secondNumber, firstNumber % secondNumber,
			secondNumber, firstNumber, secondNumber / firstNumber,
			secondNumber, firstNumber, secondNumber % firstNumber);
	}
}
