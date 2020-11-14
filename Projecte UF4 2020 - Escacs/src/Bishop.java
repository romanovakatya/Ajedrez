//Alfil/слон A a
public class Bishop extends Piece {
	public Bishop(boolean isWhite) {
		super(isWhite);

	}
	
	@Override
	public String toString() {
		return this.isWhite() ? "A" : "a";
	}
}
