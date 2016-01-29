package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;
import com.devinhartzell.chess.gui.ChessGameWindow;

public abstract class ChessPiece {
	
	/*
	 * For type:
	 * p - pawn
	 * r - rook
	 * n - knight
	 * b - bishop
	 * q - queen
	 * k - king
	 * 0 - null
	 */
	public char type;
	
	/*
	 * true = white
	 * false = black
	 */
	protected boolean color;
	protected boolean isNull = false;
	protected int x, y;
	protected int oldx, oldy;
	protected BufferedImage image;
	
	protected boolean hasMoved = false;
	
	protected Board board;
	
	// gets the moves from the piece's current position
	public abstract ArrayList<Coordinate> getPossibleMoves();
	
	
	public ArrayList<ChessPiece> getProtectors() {
		ArrayList<ChessPiece> protectors = new ArrayList<ChessPiece>();
		for (int m = 1; m <= 8; m++) {
			for (int n = 1; n <= 8; n++) {
				ChessPiece pe = board.getBoardArray()[m][n].getPiece();
				if (pe.getType() != '0' && !(pe instanceof King)) {
					if (pe.getColor() == this.color) {
						if (pe != this) {
							for (Coordinate c : pe.getPossibleMoves()) {
								if (c.equals(new Coordinate(x,y))) {
									protectors.add(pe);
									break;
								}
							}
						}	
					}
				}
			}
		} return protectors;
	}
	
	public abstract boolean isNull();
	
	public boolean getColor() {
		return color;
	}
	
	public char getType() {
		return type;
	}

	public void move(int new_x, int new_y) {
		
		oldx = this.x;
		oldy = this.y;
		this.x = new_x;
		this.y = new_y;
		hasMoved = true;
		
		boolean cap;
		if (board.getBoardArray()[new_x][new_y].getPiece().getType() == '0')
			cap = false;
		else
			cap = true;
		
		if (board.isMainBoard())
			ChessGameWindow.addMove(this, cap);
			
		
		
		
		for (Coordinate s : board.getBoardArray()[oldx][oldy].getPiece().getPossibleMoves())
			board.getBoardArray()[s.getX()][s.getY()].setHighlighted(false);
		
			
		
		board.getBoardArray()[oldx][oldy].setPiece(new NullPiece(this.x, this.y, board));
		if (board.isMainBoard())
			board.getBoardArray()[oldx][oldy].getPanel().setSelected(false);
		board.getBoardArray()[new_x][new_y].setPiece(this);
		//System.out.println(board.getBoardArray()[new_x][new_y].getPiece().toString());
		
		
		
		if (board.isMainBoard()) {
			board.setTurn(!board.getTurn());
		}
		
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void kill() {
		this.x = 0;
		this.y = 0;
	}
	
	public boolean checkIfNull()
	{
		return isNull;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getOldX() {
		return oldx;
	}
	
	public int getOldY() {
		return oldy;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public boolean hasMoved() {
		return hasMoved;
	}
}
