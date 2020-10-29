//https://www.arquitecturajava.com/eclipse-git-repositorios/

//clase principal para fichas, que contiene caracteristicas comunes,
public class Piece {
	
	//columna puede ser a - h,
	//fila puede ser 8 - 1,
	//color puede ser blanco o negro,
	char positionColumn;
	int positionRow;
	char nextPositionColumn;
	int nextPositionRow;
	String color;
	
	//constructor,
	public Piece(char positionColumn, int positionRow, String color) {
		this.positionColumn = positionColumn;
		this.positionRow = positionRow;
		this.color = color;
	}

	//método para mover ficha,
	public void move(char nextPositionColumn, int nextPositionRow) {
		this.positionColumn = nextPositionColumn;
		this.positionRow = nextPositionRow;
	}
}
