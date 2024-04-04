import java.util.Scanner;

public class Problem {
	protected Scanner inputReader = new Scanner(System.in);
	
	private int problemNumber;
	private String problemName, problemDescription;

	public Problem(int number, String name, String description) {
		this.problemNumber = number;
		this.problemName = name;
		this.problemDescription = description;
	}

	public int getNumber() {
		return problemNumber;
	}

	public String getName() {
		return problemName;
	}

	public String getDescription() {
		return problemDescription;
	}

	public void run() {
		System.out.println("placeholder function");
	}
}
