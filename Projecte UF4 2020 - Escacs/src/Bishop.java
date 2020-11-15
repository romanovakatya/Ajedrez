//Alfil/слон A a
public class Bishop extends Piece {

	public Bishop(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public String toString() {
		return this.isWhite() ? "A" : "a";
	}

	// to control piece movement,
	@Override
	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn, boolean positionIsEmpty) {
		return Math.abs(initialRow - nextRow) == Math.abs(initialColumn - nextColumn);
	}

}
