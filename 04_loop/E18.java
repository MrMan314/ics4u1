import java.util.Scanner;

public class E18 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter your first name: ");
		String firstName = inputReader.nextLine();
		System.out.print("Enter your middle initial: ");
		String middleInitial = inputReader.nextLine();
		System.out.print("Enter your last name: ");
		String lastName = inputReader.nextLine();

		String monogram = "" +
			firstName.toLowerCase().charAt(0) +
			lastName.toUpperCase().charAt(0) +
			middleInitial.toLowerCase().charAt(0);

		System.out.printf("\nYour monotgram is: %s\n", monogram);
	}
}
