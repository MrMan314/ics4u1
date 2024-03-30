import java.util.Random;

public class E13 {
	private static Random randomGenerator = new Random();
	private static int board[] = new int[25];
	private static int prizes[] = new int[6];
	private static String idToPrize[] = {"      ", "puzzle", " game ", " ball ", "poster", " doll "};

	private static void displayBoard() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("[%s]", idToPrize[board[i * 5 + j]]);
			}
			System.out.println();
		}
	}

	private static void fillBoard() {
		for(int i = 1; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				int tile = 0;
				do {
					tile = randomGenerator.nextInt(25);
				} while(board[tile] != 0);
				board[tile] = i;
			}
		}
	}

	private static void playRound() {
		int spot = randomGenerator.nextInt(25);
		int prize = board[spot];
		board[spot] = 0;
		prizes[prize]++;
	}

	public static void main(String[] args) {
		fillBoard();
		displayBoard();
		for(int i = 0; i < 10; i++) {
			playRound();
		}
		boolean wonSomething = false;
		for(int i = 1; i < 6; i++) {
			if(prizes[i] > 2) {
				System.out.printf("Player wins a %s!\n", idToPrize[i].strip());
				wonSomething = true;
			}
		}
		if(!wonSomething) {
			System.out.println("Player did not win anything :(((");
		}
	}
}
