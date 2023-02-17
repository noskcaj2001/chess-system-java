package chess.pieces;


import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p= (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
		
	}
	
	
	

	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getRows()];
		
		Position p = new Position(0, 0);
		
		//testando o movimento  do rei para CIMA
		p.setValues(position.getRow() -1, position.getColumn());
		if(getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		//testando o movimento  do rei para BAIXO
		p.setValues(position.getRow() +1, position.getColumn());
		if(getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		//testando o movimento rei para ESQUERDA
		p.setValues(position.getRow(), position.getColumn()-1);
		if(getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		//testando o movimento do rei para DIREITA
		p.setValues(position.getRow(), position.getColumn()+1);
		if(getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		//testando o movimento do rei para NOROESTE
		p.setValues(position.getRow()-1, position.getColumn()-1);
		if(getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		//testando o movimento do rei para NORDESTE
		p.setValues(position.getRow()-1, position.getColumn()+1);
		if(getBoard().positionExistis(p) && canMove(p)) { 
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		//testando o movimento do rei para SUDOESTE
		p.setValues(position.getRow()+1, position.getColumn()-1);
		if(getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		//testando o movimento do rei para SUDESTE
		p.setValues(position.getRow()+1, position.getColumn()+1);
		if(getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			
		}
		
		
		return mat;
		
	}
}

