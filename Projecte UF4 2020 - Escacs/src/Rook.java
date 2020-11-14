//Torre/ладья T t 
public class Rook extends Piece{
	
	public Rook(boolean isWhite) {
		super(isWhite);

	}
	
	@Override
	public String toString() {
		return this.isWhite() ? "T" : "t";
	}

}
