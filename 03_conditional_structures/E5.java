import java.util.Scanner;

public class E5 {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		System.out.print("Enter the percentage: ");
		int grade = inputReader.nextInt();
		inputReader.nextLine();
		System.out.print("The corresponding letter grade is: ");
		if(grade < 60) {
			System.out.println("F");
		} else if (grade < 70) {
			System.out.println("D");
		} else if (grade < 80) {
			System.out.println("C");
		} else if (grade < 90) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}
}
