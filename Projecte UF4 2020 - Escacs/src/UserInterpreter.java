import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterpreter {
	Scanner keyboard = new Scanner(System.in);

	public String positionPiece;
	private boolean turn = true;
	private boolean initial = true;
	private int[] positionMatrix;
	final Map<String, int[]> positions = new HashMap<String, int[]>();
	private char[] columns = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
	private char[] rows = new char[] { '8', '7', '6', '5', '4', '3', '2', '1' };

	// indicate players' turn,

	public void indicateTurn() {
		if (this.turn) {
			System.out.println("Jugador 1 (blancos). ");
		} else {
			System.out.println("Jugador 2 (negros). ");
		}
	}

	// function that changes players turn,

	public void changeTurn() {
		if (this.turn) {
			this.turn = false;
		} else {
			this.turn = true;
		}
	}

	// get turn,
	public boolean isTurn() {
		return turn;
	}

	/**
	 * to request the piece position,
	 * 
	 * @return
	 */
	public String askPosition() {
		if (this.initial) {
			System.out.println("La posición de la pieza que quere mover (letra(a-h)número(8-1)):");
			return this.positionPiece = keyboard.next();

		} else {
			System.out.println("A que posición quiere moverla (letra(a-h)número(8-1)):");
			return this.positionPiece = keyboard.next();
		}
	}

	// to be able to request the next position,
	public boolean changeInitialToNext() {
		if (this.initial) {
			return this.initial = false;
		} else {
			return this.initial = true;
		}
	}

	// to fill map object with key is user position and value is position of matrix
	// that corresponds to it,
	private void fillInPositions() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				int[] realPositions = new int[] { i, j };
				positions.put(Character.toString(columns[i]) + Character.toString(rows[j]), realPositions);
			}
		}
	}

	// get array position from user entered position,
	int[] getPositionMatrix(String userPosition) {
		fillInPositions();
		return positions.get(userPosition);
	}

	// check if user has entered the position that exists on the board,
	public String positionExists(String userPosition) {
		this.positionMatrix = getPositionMatrix(userPosition);

		while (this.positionMatrix == null) {
			System.out.println("La posición indicada no existe.");
			userPosition = askPosition();
			this.positionMatrix = getPositionMatrix(userPosition);
		}
		return userPosition;
	}

	// get position row,
	int getRow(String userPosition) {
		this.positionMatrix = getPositionMatrix(userPosition);
		return this.positionMatrix[1];
	}

	// get position column,
	int getColumn(String userPosition) {
		this.positionMatrix = getPositionMatrix(userPosition);
		return this.positionMatrix[0];
	}

	// check if home position is empty,
	public void positionIsEmpty() {
		System.out.println("El movimiento es incorrecto. La posicion inicial está vacia");
	}

	// when one of the kings has died,
	public void endOfGame() {
		System.out.println("Juego se ha acabado. Ha ganado: ");
		indicateTurn();
	}
}
