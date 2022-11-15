package chess;

import boardgame.Position;

//CONVERTER POSIÇÕES COM LETRAS (A1, A4 B5 ETC) PARA POSIÇÕES NA MATRIZ ( 1,1 ; 1,2 ETC) E VICE VERSA
public class ChessPosition {
	
	private char column;
	private int row;
	
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro instanciando ChessPosition (Posição no xadres). Valores validos são a1 até h8.");
		}
		this.column = column;
		this.row = row;
	}


	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	//CONVERSÃO
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//CONVERSÃO INVERSA
	protected static ChessPosition fromPosition(Position positon) {
		return new ChessPosition((char)('a' - positon.getColumn()), 8 - positon.getRow());
	}
	
	@Override
	public String toString() {
		return " " + column + row;
	}



}


/* LEMBRA-SE LINHA DA MATRIZ = 8 - LINHA DO XADREZ 
 * 
 * 'a' - 'a' = 0
 * 'b' - 'a' = 1
 * 'c' - 'a' = 2
 * 
 * COLUNAS :
 * a = 0
 * b = 1
 * c = 2
 * d = 3
 * 
 * Formula geral para achar a coluna da MATRIZ
 * 
 * MATRIZ_COLUNA = COLUNA_XADREZ - 'a'
	
*/















