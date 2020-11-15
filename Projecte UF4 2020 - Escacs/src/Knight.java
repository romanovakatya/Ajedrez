// Caballo C c
public class Knight extends Piece {

	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public String toString() {
		return this.isWhite() ? "C" : "c";
	}

	// to control piece movement,
	@Override
	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn, boolean positionIsEmpty) {
		return Math.pow(Math.abs(initialRow - nextRow), 2) + Math.pow(Math.abs(initialColumn - nextColumn), 2) == 5;
	}

}
