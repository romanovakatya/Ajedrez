
//the main class where the whole game happens,
public class Chess {

	public static void main(String[] args) {
		UserInterpreter user = new UserInterpreter();
		Chessboard board = new Chessboard();
		System.out.println(board.toString());

		String inicialPosition;
		String nextPosition;

		// start of the game,
		user.indicateTurn();

		// get which piece user wants to move,
		inicialPosition = user.askPosition();
		inicialPosition = user.positionExists(inicialPosition);
		int initialRow = user.getRow(inicialPosition);
		int initialColumn = user.getColumn(inicialPosition);

		// check if players turn has not been changed,

		while (user.isTurn() != board.checkIsWhite(initialRow, initialColumn)) {
			System.out.println("La pieza que quiere mover no coincide al turno de jugador.");
			user.indicateTurn();
			inicialPosition = user.askPosition();
			inicialPosition = user.positionExists(inicialPosition);
			initialRow = user.getRow(inicialPosition);
			initialColumn = user.getColumn(inicialPosition);
		}

		// check if initial position contains piece,
		while (board.positionIsEmpty(initialRow, initialColumn)) {
			user.positionIsEmpty();
			inicialPosition = user.askPosition();
			inicialPosition = user.positionExists(inicialPosition);
			initialRow = user.getRow(inicialPosition);
			initialColumn = user.getColumn(inicialPosition);
			board.positionIsEmpty(initialRow, initialColumn);
		}

		// where to move it,
		user.changeInitialToNext();
		nextPosition = user.askPosition();
		nextPosition = user.positionExists(nextPosition);
		int nextRow = user.getRow(nextPosition);
		int nextColumn = user.getColumn(nextPosition);

		if (board.move(initialRow, initialColumn, nextRow, nextColumn)) {
			user.changeTurn();
		}
		;
		System.out.println(board.toString());

		while (board.isKingsAreAlive()) {
			// get which piece user wants to move,
			user.indicateTurn();
			user.changeInitialToNext();
			inicialPosition = user.askPosition();
			inicialPosition = user.positionExists(inicialPosition);
			initialRow = user.getRow(inicialPosition);
			initialColumn = user.getColumn(inicialPosition);

			// check if players turn has not been changed,

			while (user.isTurn() != board.checkIsWhite(initialRow, initialColumn)) {
				System.out.println("La pieza que quiere mover no coincide al turno de jugador.");
				user.indicateTurn();
				inicialPosition = user.askPosition();
				inicialPosition = user.positionExists(inicialPosition);
				initialRow = user.getRow(inicialPosition);
				initialColumn = user.getColumn(inicialPosition);
			}

			// check if initial position contains piece,
			while (board.positionIsEmpty(initialRow, initialColumn)) {
				user.positionIsEmpty();
				inicialPosition = user.askPosition();
				inicialPosition = user.positionExists(inicialPosition);
				initialRow = user.getRow(inicialPosition);
				initialColumn = user.getColumn(inicialPosition);
				board.positionIsEmpty(initialRow, initialColumn);
			}

			// where to move it,
			user.changeInitialToNext();
			nextPosition = user.askPosition();
			nextPosition = user.positionExists(nextPosition);
			nextRow = user.getRow(nextPosition);
			nextColumn = user.getColumn(nextPosition);

			if (board.move(initialRow, initialColumn, nextRow, nextColumn)) {
				if (board.isKingsAreAlive()) {
					user.changeTurn();
				}
				;
			}
			;
			System.out.println(board.toString());
		}

		// end of the game when one of the kings has died,
		user.endOfGame();
	}
}