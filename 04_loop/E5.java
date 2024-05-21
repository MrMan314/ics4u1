import java.util.Scanner;

public class E5 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int givenNumber = inputReader.nextInt();
		inputReader.nextLine();
		while(givenNumber < 1) {
			System.out.print("Enter a POSITIVE integer: ");
			givenNumber = inputReader.nextInt();
			inputReader.nextLine();
		}
		int digitCount = (int) Math.log10(givenNumber);
		for(int i = digitCount; i >= 0; i--) {
			System.out.println((int) (givenNumber / Math.pow(10,i) % 10));
		}
	}
}
