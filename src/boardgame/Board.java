package boardgame;


//TABULEIRO 
public class Board {
	
	private int rows;
	private int columns;
	private Piece [][] pieces;
	
	
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: é necessário que haja pelo menos 1 linha e 1 coluna.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}



	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	
	
	public Piece piece(int row, int column) {
		if(!positionExistis(row, column)) {
			throw new BoardException("Não existe essa posição no tabuleiro");
		}
		return pieces [row][column];
	}
	
	public Piece piece(Position positions) {
		if(!positionExistis(positions)) {
			throw new BoardException("Não existe essa posição no tabuleiro");
		}
		return pieces[positions.getRow()][positions.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça na posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;		
	}
	
	public Piece removePiece(Position position) {
		if(!positionExistis(position)) {
			throw new BoardException("Não existe essa posição no tabuleiro");	
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	
	//Methods: Board.PositionExists, Board.ThereIsAPiece
	private boolean positionExistis(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns; 
	}
	
	public boolean positionExistis(Position position) {
		return positionExistis(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExistis(position)) {
			throw new BoardException("Não existe essa posição no tabuleiro");
		}
		return piece(position) != null;
	}
	
	

}
