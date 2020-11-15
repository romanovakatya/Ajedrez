//https://www.arquitecturajava.com/eclipse-git-repositorios/

//clase principal para fichas, que contiene caracteristicas comunes,
public class Piece extends Cell {
	private boolean isWhite;

	public Piece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public boolean canMove(int initialRow, int initialColumn, int nextRow, int nextColumn, boolean positionIsEmpty) {
		return true;
	}
}