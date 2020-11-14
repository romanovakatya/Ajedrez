// Peón P p
public class Pawn extends Piece {

	public Pawn(boolean isWhite) {
		super(isWhite);
	}
	
	@Override
	public String toString() {
		return this.isWhite() ? "P" : "p";
	}
	
	@Override
	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn, boolean positionIsEmpty) {
		if (positionIsEmpty) {
			if (this.isWhite()) {
				//white move
				return (initialRow - 1 == nextRow && initialColumn == nextColumn) ||
						(initialRow == 6 && initialRow - 2 == nextRow && initialColumn == nextColumn);
			}
			else {
				//black move
				return (initialRow + 1 == nextRow && initialColumn == nextColumn) ||
				(initialRow == 1 && initialRow + 2 == nextRow && initialColumn == nextColumn);
			}
		}
		else {
			if (this.isWhite()) {
				//for white pawn to kill another piece:
				return (initialRow - 1 == nextRow && initialColumn - 1 == nextColumn) || 
						(initialRow - 1 == nextRow && initialColumn + 1 == nextColumn);
			}
			else {
				//for black pawn to kill another piece:
				return (initialRow + 1 == nextRow && initialColumn - 1 == nextColumn) || 
						(initialRow + 1 == nextRow && initialColumn + 1 == nextColumn);
			}
		}
	}

}
