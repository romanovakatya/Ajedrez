
public class Chessboard {

	public King king;
	public Queen queen;
	public Bishop bishop;
	public Knight knight;
	public Rook rock;
	public Pawn pawn;
	public Object[][] board;

	// builder,
	public Chessboard() {
		this.board = new Object[8][8];
		for (Object object : board) {
			object = new Object[8];
		}

		// black:
		this.board[0][0] = new Rook(false);
		this.board[0][1] = new Knight(false);
		this.board[0][2] = new Bishop(false);
		this.board[0][3] = new Queen(false);
		this.board[0][4] = new King(false);
		this.board[0][5] = new Bishop(false);
		this.board[0][6] = new Knight(false);
		this.board[0][7] = new Rook(false);
		for (int i = 0; i < board.length; i++) {
			this.board[1][i] = new Pawn(false);
		}
		// white:
		for (int i = 0; i < board.length; i++) {
			this.board[6][i] = new Pawn(true);
		}
		this.board[7][0] = new Rook(true);
		this.board[7][1] = new Knight(true);
		this.board[7][2] = new Bishop(true);
		this.board[7][3] = new Queen(true);
		this.board[7][4] = new King(true);
		this.board[7][5] = new Bishop(true);
		this.board[7][6] = new Knight(true);
		this.board[7][7] = new Rook(true);

		// free place on board:
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < board.length; j++) {
				this.board[i][j] = new Cell();
			}
		}
	}

	/**
	 * to show board,
	 */
	@Override
	public String toString() {
		String string = "";
		for (Object[] objects : board) {

			for (Object object : objects) {
				string += " " + object.toString() + " ";
			}
			string += "\n";
		}
		return string;
	}

	/**
	 * check if the position occupies a white or black piece,
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean checkIsWhite(int row, int column) {
		if (positionIsEmpty(row, column)) {
			return true;
		} else {
			return ((Piece) this.board[row][column]).isWhite();
		}
	}

	/**
	 * to move any piece,
	 * 
	 * @param initialRow
	 * @param initialColumn
	 * @param nextRow
	 * @param nextColumn
	 * @return
	 */
	public boolean move(int initialRow, int initialColumn, int nextRow, int nextColumn) {
		if (this.canMove(initialRow, initialColumn, nextRow, nextColumn)) {
			this.board[nextRow][nextColumn] = this.board[initialRow][initialColumn];
			this.board[initialRow][initialColumn] = new Cell();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check if piece can move to indicated position,
	 * 
	 * @param initialRow
	 * @param initialColumn
	 * @param nextRow
	 * @param nextColumn
	 * @return
	 */
	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn) {
		if (this.positionExists(initialRow, initialColumn) && this.positionExists(nextRow, nextColumn)) {

			if (!this.positionIsEmpty(initialRow, initialColumn)) {
				// checking for initial color of the piece:
				boolean isWhite = ((Piece) this.board[initialRow][initialColumn]).isWhite();
				boolean nextPositionIsEmpty = this.positionIsEmpty(nextRow, nextColumn);
				if (!nextPositionIsEmpty) {
					// if they have the same color, no move
					if ((((Piece) this.board[nextRow][nextColumn]).isWhite() && isWhite)
							|| (!((Piece) this.board[nextRow][nextColumn]).isWhite() && !isWhite)) {
						System.out.println("Las dos piezas tienen el mismo color. El ataque es imposible.");
						return false;
					}
				}
				if (((Piece) this.board[initialRow][initialColumn]).canMove(initialRow, initialColumn, nextRow,
						nextColumn, this.positionIsEmpty(nextRow, nextColumn))) {

					return isPathEmpty(initialRow, initialColumn, nextRow, nextColumn);
				} else {
					System.out.println("El movimiento es incorrecto.");
					return false;
				}
			} else {
				System.out.println("El movimiento es incorrecto. La posicion inicial está vacia");
				return false;
			}
		} else {
			System.out.println("El movimiento es imposible.");
			return false;
		}
	}

	/**
	 * check if position exists on board,
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < 8 && column >= 0 && column < 8;
	}

	/**
	 * check if position is empty,
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean positionIsEmpty(int row, int column) {
		return this.board[row][column].toString().equals("•");
	}

	/**
	 * check if the path between two piece is clear,
	 * 
	 * @param initialRow
	 * @param initialColumn
	 * @param nextRow
	 * @param nextColumn
	 * @return
	 */
	public boolean isPathEmpty(int initialRow, int initialColumn, int nextRow, int nextColumn) {
		int start;
		int finish;

		// check for all values in horizontal,
		if (initialRow == nextRow) {
			if (initialColumn > nextColumn) {
				start = nextColumn;
				finish = initialColumn;
			} else {
				start = initialColumn;
				finish = nextColumn;
			}
			// start+1 for not to count the position of piece,
			for (int i = start + 1; i < finish; i++) {
				if (!this.positionIsEmpty(initialRow, i)) {
					System.out.println("El movimiento es imposible. Hay una pieza en el camino horisontal");
					return false;
				}
			}
			return true;
		}
		// check for all values in vertical,
		else if (initialColumn == nextColumn) {
			if (initialRow > nextRow) {
				start = nextRow;
				finish = initialRow;
			} else {
				start = initialRow;
				finish = nextRow;
			}
			// start+1 for not to count the position of piece,
			for (int i = start + 1; i < finish; i++) {
				if (!this.positionIsEmpty(i, initialColumn)) {
					System.out.println("El movimiento es imposible. Hay una pieza en el camino vertical");
					return false;
				}
			}
			return true;
		}

		// check for all values in diagonal:
		// 0,0 ; 1,1 ; ...
		else if (Math.abs(initialRow - nextRow) == Math.abs(initialColumn - nextColumn)) {
			if (initialRow > nextRow) {
				if (initialColumn > nextColumn) {
					for (int i = 1; i < initialRow - nextRow; i++) {
						if (!this.positionIsEmpty(nextRow + i, nextColumn + i)) {
							System.out.println("El movimiento es imposible. Hay una pieza en el camino");
							return false;
						}
					}
				} else {
					for (int i = 1; i < initialRow - nextRow; i++) {
						if (!this.positionIsEmpty(nextRow + i, Math.abs(nextColumn - i))) {
							System.out.println("El movimiento es imposible. Hay una pieza en el camino");
							return false;
						}
					}
				}
				return true;
			} else {
				if (initialColumn > nextColumn) {
					for (int i = 1; i < nextRow - initialRow; i++) {
						if (!this.positionIsEmpty(initialRow + i, Math.abs(initialColumn - i))) {
							System.out.println("El movimiento es imposible. Hay una pieza en el camino");
							return false;
						}
					}
				} else {
					for (int i = 1; i < nextRow - initialRow; i++) {
						if (!this.positionIsEmpty(initialRow + i, initialColumn + i)) {
							System.out.println("El movimiento es imposible. Hay una pieza en el camino");
							return false;
						}
					}
				}
				return true;
			}
		}
		// for the Knight:
		else {
			return true;
		}
	}

	// end of the game: check if there are kings on the board,
	public boolean isKingsAreAlive() {
		int contador = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (this.board[i][j].toString().equalsIgnoreCase("k")) {
					contador++;
				}
			}
		}
		if (contador < 2) {
			return false;
		}
		return true;
	}
}
