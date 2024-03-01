import java.util.Scanner;

public class E20 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter text: ");
		String userInput = inputReader.nextLine();
		String processedInput = userInput.toUpperCase();
		int vowelCount = 0;
		for(int i = 0; i < userInput.length(); i++) {
			if(	processedInput.charAt(i) == 'A' ||
				processedInput.charAt(i) == 'E' ||
				processedInput.charAt(i) == 'I' ||
				processedInput.charAt(i) == 'O' ||
				processedInput.charAt(i) == 'U'	) {
					vowelCount++;
				}
		}
		System.out.printf("The number of vowels in %s is %d\n", userInput, vowelCount);
	}
}
