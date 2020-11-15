//Rey K k

public class King extends Piece {

	public King(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public String toString() {
		return this.isWhite() ? "K" : "k";
	}

	// to control piece movement,
	@Override
	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn, boolean positionIsEmpty) {
		return (Math.abs(initialRow - nextRow) <= 1) && (Math.abs(initialColumn - nextColumn) <= 1);
	}

}
