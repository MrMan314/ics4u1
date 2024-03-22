public class Main {
	public static void main(String[] args) {
		Problem[] problems = new Problem[2];
		problems[0] = new E2();
		problems[1] = new E5();
		System.out.println("Please select the question you want to run from the following list:");
		for (Problem problem: problems) {
			System.out.printf("\t%d: %s\n\t\t%s\n", problem.getNumber(), problem.getName(), problem.getDescription());
		}
		System.out.print("Please enter the question number or name, or 'q' to quit > ");
	}
}
