package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.ChessGame;
import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;
import com.devinhartzell.chess.board.Square;

public class King extends ChessPiece {
	
	private final String WHITE_PATH = "/resources/pieces/k_w.png";
	private final String BLACK_PATH = "/resources/pieces/k_b.png";
	
	public King(int x, int y, boolean color, Board board) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'k';
		this.board = board;
		try {
			if (color)
				this.image = ImageIO.read(getClass().getResource(BLACK_PATH));
			else
				this.image = ImageIO.read(getClass().getResource(WHITE_PATH));
			
			ChessGame.getMainBoard().getBoardArray()[x][y].setPiece(this);
		}
		catch (Exception e) {
			System.out.println("Error: Could not load pawn resource");
		}
	}
	
	@Override
	public ArrayList<Coordinate> getPossibleMoves() {
		ArrayList<Coordinate> movesList = new ArrayList<Coordinate>();
		
		// Go clockwise from the top
		
		int[] xc = {x, x+1, x+1, x+1, x, x-1, x-1, x-1};
		int[] yc = {y+1, y+1, y, y-1, y-1, y-1, y, y+1};
		
		// left three spaces
		for (int i = 0; i <= 7; i++)
		{
			if (xc[i] <= 8 && xc[i] >= 1 && yc[i] <=8 && yc[i] >= 1) {
				if (ChessGame.getMainBoard().getBoardArray()[xc[i]][yc[i]].hasPiece()) {
					if (ChessGame.getMainBoard().getBoardArray()[xc[i]][yc[i]].getPiece().getColor() != this.color) {
						movesList.add(new Coordinate(xc[i], yc[i]));
					}
				} else {
					movesList.add(new Coordinate(xc[i], yc[i]));
				}
			}
		}
		
		for (int m = 1; m <= 8; m++) {
			for (int n = 1; n <= 8; n++) {
				Square sq = ChessGame.getMainBoard().getBoardArray()[m][n];
				if (sq.hasPiece()) {
					if (!(sq.getPiece() instanceof King)) {
						if (sq.getPiece().getColor() != this.color) {
							if (sq.getPiece().getProtectors().size() <= 0) {
								ArrayList<Coordinate> noMoves = sq.getPiece().getPossibleMoves();
								ArrayList<Coordinate> intersection = new ArrayList<Coordinate>();
								
								for (Coordinate c : movesList)
									for (Coordinate d : noMoves)
										if (c.equals(d))
											intersection.add(c);
								
								for (Coordinate c : intersection)							
									movesList.remove(c);	
							}
						}
					}	
				}
			}
		}
				
		return movesList;
	}
	
	public boolean getCheck() {
		for (int m = 1; m <= 8; m++) {
			for (int n = 1; n <= 8; n++) {
				Square sq = ChessGame.getMainBoard().getBoardArray()[m][n];
				if (sq.hasPiece()) 
					if (sq.getPiece().getColor() != this.color) 
						for (Coordinate c : sq.getPiece().getPossibleMoves()) 
							if (c.equals(new Coordinate(this.x, this.y))) 
								return true;
			}	
		}		return false;
	}

	
	public ArrayList<ChessPiece> getAttackers() {
		ArrayList<ChessPiece> attackers = new ArrayList<ChessPiece>();
		
		for (int m = 1; m <= 8; m++) {
			for (int n = 1; n <= 8; n++) {
				//System.out.println("Testing piece at " + m + ", " + n);
				if (ChessGame.getMainBoard().getBoardArray()[m][n].getPiece().isNull() != this.isNull()) {
					ChessPiece pe = ChessGame.getMainBoard().getBoardArray()[m][n].getPiece();
					if (!(pe instanceof NullPiece)) {
						if (pe.getColor() != this.color) {
							for (Coordinate c : pe.getPossibleMoves()) {
								if (c.equals(new Coordinate(x, y))) {
									if (!attackers.contains(pe))
										attackers.add(pe);
								}
							}
						}
					}
				}
			}
		} return attackers;
	}
	
	public ArrayList<ChessPiece> getSameColorPieces() {
		ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();
		for (int m = 1; m <= 8; m++) {
			for (int n = 1; n <= 8; n++) {
				ChessPiece pe = ChessGame.getMainBoard().getBoardArray()[m][n].getPiece();
				if (!pe.isNull()) {
					if (pe.getColor() == this.color) {
						pieces.add(pe);
					}
				}
			}
		} return pieces;
	}

	public boolean getCheckMate() {
		
		/*
		if (getCheck()) {
			// Loop all moves
			for (ChessPiece friendPiece : getSameColorPieces()) {
				for (Coordinate move : friendPiece.getPossibleMoves()) {
					// Assume that it solves checkmate
					boolean solvesCM = true;
					
					// Test the move with all attackers
					for (ChessPiece attacker : getAttackers()) {
						/*for (Coordinate attackerMove : attacker.getTheoreticalMoves
								(friendPiece, move.getX(), move.getY())) {
							// If an attacker's move contains the king's space, say that it didn't work
							if (attackerMove.equals(new Coordinate(this.x, this.y))) {
								solvesCM = false;
							}
						}
					}   
					
					if (solvesCM) {
						return false;
					}
				}
			}
			
			return true;
		} else
			return false;
		
		*/
		return false;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}

	@Override
	public boolean isNull() {
		return false;
	}
}