//Reina/Dama/ферзь  Q q 
public class Queen extends Piece {

	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public String toString() {
		return this.isWhite() ? "Q" : "q";
	}

	// to control piece movement,
	@Override
	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn, boolean positionIsEmpty) {
		return ((initialRow == nextRow) || (initialColumn == nextColumn))
				|| (Math.abs(initialRow - nextRow) == Math.abs(initialColumn - nextColumn));
	}

}
