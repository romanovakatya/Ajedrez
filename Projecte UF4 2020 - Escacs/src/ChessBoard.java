//tablero,

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author katia
 *
 */

public class ChessBoard {

	// variables,
	/*
	 * char [][] chessBoard = {{'t','c','a','q','k','a','c','t'},
	 * {'p','p','p','p','p','p','p','p'}, {'•','•','•','•','•','•','•','•'},
	 * {'•','•','•','•','•','•','•','•'}, {'•','•','•','•','•','•','•','•'},
	 * {'•','•','•','•','•','•','•','•'}, {'P','P','P','P','P','P','P','P'},
	 * {'T','C','A','Q','K','A','C','T'}};
	 */
	Scanner keyboard = new Scanner(System.in);

	String inicialPosition;
	String nextPosition;
	
	/**
	 * EL objeto que asigna claves a valores,
	 */
	final Map<String, int[]> positions = new HashMap<String, int[]>();
	private char[] columns = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	private char[] rows = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
	
	/*private String[][] columnsRows = {{"a", "b", "c", "d", "e", "f", "g", "h"},
													{"8", "7", "6", "5", "4", "3", "2", "1"}};*/
	
	// métodos,
	/**
	 * para mostrar tablero por console, 
	 * @param chessBoard

	 */
	public void mostrar(char[][] chessBoard) {
		for (int i = 0; i < chessBoard.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < chessBoard[i].length; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
		}
	}

	/**
	 * para pedir posición inicial de una ficha que quiere mover usuario,
	 */
	public String askInicialPosition() {

		System.out.println("\nIntroduce la posición de la figura que quere mover:");
		return this.inicialPosition = keyboard.next();
}
	/**
	 * para pedir posición siguiente de una ficha a donde quiere moverla usuario,
	 */
	
	public String askNextPosition() {
		System.out.println("Diga a que posición quiere moverla:");
		return this.nextPosition = keyboard.next();
	}
	
	/**
	 * para representar posiciones reales de matriz en formato key : value,
	 * donde key es la posición introducida por usuario,
	 */
	private void fillInpositions() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				int[] realPositions = new int[]{i, j};
				positions.put(Character.toString(columns[i]) + Character.toString(rows[j]), realPositions);
			}
		}
	}
	
	/**
	 * para obtener la posición real de la ficha en martiz,
	 * @param positionUser
	 * @return
	 */
	int[] getPositionReal(String userPosition){
		fillInpositions();
		return positions.get(userPosition);
	}
 

	/**
	 * comprobar si la posición elegida está vacia,
	 * @param fila
	 * @param columna
	 * @return
	 */
	public boolean isEmptyPosition(int fila, String columna) {

		return true;
	}

}
