import java.util.Random;

public class E1 {
	public static void main(String[] args) {
		Random randomGenerator = new Random();
		System.out.println("      B      I      N      G      O");
		int[] card = new int[25];
		int n = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if (i == 2 && j == 2) {
					System.out.print("   FREE");
				} else {
					boolean invalidNumber = true;
					while (invalidNumber) {
						boolean found = false;
						n = randomGenerator.nextInt(15) + 1 + j * 15;
						for(int k = j; k < 25; k += 5) {
							if(n == card[k]) {
								found = true;
								break;
							}
						}
						if(!found) {
							card[i * 5 + j] = n;
							invalidNumber = false;
						}
					}
					int spaces = 7 - Integer.toString(n).length();
					for(int k = 0; k < spaces; k++) System.out.print(" ");
					System.out.print(n);
				}
			}
			System.out.println();
		}
	}
}
