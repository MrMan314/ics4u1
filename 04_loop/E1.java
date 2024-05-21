import java.util.Scanner;

public class E1 {
	private static Scanner inputReader = new Scanner(System.in);

	private static boolean isPrime(int n) {
		if(n < 2) return false;
		for(int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static void checkPrime() {
		System.out.print("Please enter a number > ");
		int givenNumber = inputReader.nextInt();
		inputReader.nextLine();
		System.out.printf("%d is ", givenNumber);
		if(!isPrime(givenNumber)) System.out.print("not ");
		System.out.println("prime.");
	}
	
	private static void checkPrimeRange() {
		System.out.print("Please enter the lower bound value > ");
		int lowerBound = inputReader.nextInt();
		inputReader.nextLine();
		System.out.print("Please enter the upper bound value > ");
		int upperBound = inputReader.nextInt();
		inputReader.nextLine();
		System.out.printf("The prime numbers between %d and %d, inclusive are:\n", lowerBound, upperBound);
		for(int i = lowerBound; i <= upperBound; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		System.out.print(
			"There are multiple parts to this problem, please select the part you want to run from the following list:\n" +
			"\ta. Prime number\n" +
			"\t\tChecks if a given number is prime\n" +
			"\tb. Prime number range\n" +
			"\t\tLists all prime numbers in a given range\n" +
			"Please enter the letter corresponding to the desired part > ");
		String option = inputReader.nextLine();
		switch(option.toUpperCase()) {
			case "A":
				checkPrime();
				break;
			case "B":
				checkPrimeRange();
				break;
			default:
				System.out.println("Sorry, I don't know what you mean.");
		}
	}
}
