import java.util.Random;

public class E3 {
	private static Random randomGenerator = new Random();
	public static void main(String[] args) {
		int occurences[] = new int[10];
		for(int i = 0; i < 500; i++) {
			occurences[randomGenerator.nextInt(10)]++;
		}
		System.out.println("Number\tOccurences");
		for(int i = 0; i < 10; i++) {
			System.out.printf("%d\t%d\n", i, occurences[i]);
		}
	}
}
