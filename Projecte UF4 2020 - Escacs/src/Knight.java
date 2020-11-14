// Caballo C c
public class Knight extends Piece{

	public Knight(boolean isWhite) {
		super(isWhite);

	}
	
	@Override
	public String toString() {
		return this.isWhite() ? "C" : "c";
	}
}
