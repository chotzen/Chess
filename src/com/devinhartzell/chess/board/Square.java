package com.devinhartzell.chess.board;

import com.devinhartzell.chess.gui.SquarePanel;
import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.NullPiece;

public class Square {
	
	/**
	 * 
	 */

	private ChessPiece piece; /*= new NullPiece(this.getX(), this.getY());*/
	private boolean mainBoard;
	public int x, y;

	private SquarePanel panel;
	
	public Square(final int x, final int y, boolean mainBoard, Board board) {
		this.piece = new NullPiece(x, y);
		this.mainBoard = mainBoard;
		
		this.x = x;
		this.y = y;
		
		
	}
	
	public void setPanel(SquarePanel p) {
		this.panel = p;
	}
	
	public boolean isPartOfMainBoard() {
		return mainBoard;
	}
	
	public ChessPiece getPiece() {
		return piece;
	}

	public void setHighlighted(boolean b) {
		if (mainBoard)
			panel.setHighlighted(b);
	}
	
	public void setPiece(ChessPiece newpiece) {		
		this.piece = newpiece;
		if (mainBoard)
			panel.updatePiece(newpiece);
	}
	
	public boolean hasPiece() {
		return !piece.isNull();
	}
	
	public SquarePanel getPanel() {
		return panel;
	}
}