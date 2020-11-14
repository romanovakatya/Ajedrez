//Reina/Dama/ферзь  Q q 
public class Queen extends Piece{

	public Queen(boolean isWhite) {
		super(isWhite);
	}
	
	@Override
	public String toString() {
		return this.isWhite() ? "Q" : "q";
	}
}
