public class E3 {
	public static void main(String[] args) {
		int width = 15, height = 7;
		for(int i = 0; i < width; i++) {
			System.out.print("*");
		}
		System.out.println();
		for(int i = 0; i < height - 2; i++) {
			System.out.print("*");
			for(int j = 0; j < width - 2; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		for(int i = 0; i < width; i++) System.out.print("*");
		System.out.println();
	}
}
