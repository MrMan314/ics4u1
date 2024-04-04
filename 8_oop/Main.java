import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner inputReader = new Scanner(System.in);

		Problem problems[] = {
			new E1(),
			new E3()
		};

		boolean running = true;

		while (running) {
			System.out.println("Please select the question you want to run from the following list, or 'quit' to quit:");
			
			for(Problem problem: problems) {
				System.out.printf(
					"\t%d. %s\n" +
					"\t\t%s\n",
					problem.getNumber(), problem.getName(),
					problem.getDescription()
				);
			}
			
			System.out.print(" > ");

			String selection = inputReader.nextLine().strip().toUpperCase();
			
			if(selection.equalsIgnoreCase("QUIT")) {
				running = false;
			} else {
				boolean ran = false;

				for(Problem problem: problems) {
					int problemNumber = problem.getNumber();
					if(	selection.equalsIgnoreCase(problem.getName().strip()) || 
						selection.equalsIgnoreCase(Integer.toString(problemNumber).strip())) {
							problem.run();
							ran = true;
							break;
					}
				}

				if(!ran) {
					System.out.println("Sorry, I don't know what you mean!");
				}
			}
			System.out.println();
		}
	}
}
