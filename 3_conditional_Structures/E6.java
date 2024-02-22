import java.util.Scanner;
import java.util.Random;
public class E6 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		Random randomGenerator = new Random();
		int firstNumber = randomGenerator.nextInt(10) + 1;
		int secondNumber = randomGenerator.nextInt(10) + 1;
		int operation = randomGenerator.nextInt(4);
		int expectedResult;
		switch(operation) {
			case 0:
				expectedResult = firstNumber * secondNumber;
				System.out.printf("What is %d * %d? ", firstNumber, secondNumber);
				break;
			case 1:
				expectedResult = firstNumber + secondNumber;
				System.out.printf("What is %d + %d? ", firstNumber, secondNumber);
				break;
			case 2:
				expectedResult = firstNumber - secondNumber;
				System.out.printf("What is %d - %d? ", firstNumber, secondNumber);
				break;
			default:
				expectedResult = firstNumber / secondNumber;
				System.out.printf("What is %d / %d? (please truncate the decimal) ", firstNumber, secondNumber);
				break;
		}
		int result = inputReader.nextInt();
		inputReader.nextLine();
		if(expectedResult == result) {
			System.out.println("Correct!");
		} else {
			System.out.printf("Wrong, it's %d.\n", expectedResult);
		}
	}
}
