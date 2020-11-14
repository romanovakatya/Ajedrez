import java.util.Scanner;

//la clase main donde pasa todo el juego,
public class Chess {

	public static void main(String[] args) {
		Chessboard board = new Chessboard();
		System.out.println(board.toString());
		Scanner keyboard = new Scanner(System.in);
		int initialRow = keyboard.nextInt();
		int initialColumn = keyboard.nextInt();
		int nextRow = keyboard.nextInt();
		int nextColumn = keyboard.nextInt();
		System.out.println(board.move(initialRow, initialColumn, nextRow, nextColumn));
		System.out.println(board.toString());

		keyboard.close();
	}
}