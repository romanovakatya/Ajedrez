//Torre/ладья T t 

public class Rook extends Piece {

	public Rook(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public String toString() {
		return this.isWhite() ? "T" : "t";
	}

	// to control piece movement,
	@Override
	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn, boolean positionIsEmpty) {
		return (initialRow == nextRow) || (initialColumn == nextColumn);
	}

}
