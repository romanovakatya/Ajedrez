import java.util.Scanner;

//mayúscula para las piezas blancas y minúscula para las negras,



//la clase main donde pasa todo el juego,
public class Chess {

	public static void main(String[] args) {
		String inicialPosition;
		String nextPosition;
	
		Scanner keyboard = new Scanner(System.in);
		
		//introducims variables,
		ChessBoard mainChessBoard = new ChessBoard();
		//estado inicial del tablero,
		char [][] chessBoard = {{'t','c','a','q','k','a','c','t'},
				{'p','p','p','p','p','p','p','p'},
				{'•','•','•','•','•','•','•','•'}, 
				{'•','•','•','•','•','•','•','•'},
				{'•','•','•','•','•','•','•','•'},
				{'•','•','•','•','•','•','•','•'},
				{'P','P','P','P','P','P','P','P'},
				{'T','C','A','Q','K','A','C','T'}};
		
		
		//juego empieza con la mostración del tablero,
		mainChessBoard.mostrar(chessBoard);
		
		//juego continua mientras uno de los dos reyes no muere (jaque y mate).
		
		//primer paso de blancos,
		inicialPosition = mainChessBoard.askInicialPosition();
		nextPosition = mainChessBoard.askNextPosition();
		int[] inicial = mainChessBoard.getPositionReal(inicialPosition);
	
		int column = inicial[0];
		int row = inicial[1];
		System.out.println(column + " " + row);
		
		
		int[] next = mainChessBoard.getPositionReal(nextPosition);
		int columnN = next[0];
		int rowN = next[1];
		System.out.println(columnN + " " + rowN);

	}

}
