package chess;

import boardgame.Board;
import chess.pieces.Rook;

//CORAÇÃO DO JOGO(REGRAS)

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetUp();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0 ; i < board.getRows() ; i++) {
			for (int j = 0 ; j < board.getColumns(); j++) {
				//DOWCASTING
				mat[i][j] =(ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	//INSTANCIANDO E CHAMANDO A CONVERSÃO (ChessPosition)
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	//RESPONSAVEL POR INICIAR A PARTIDA COLOCANDO AS PEÇAS NO TABULEIRP(BOARD)
	private void initialSetUp() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.BLACK));
	}
	
	
	

}
