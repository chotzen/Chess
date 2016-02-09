package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

public class Rook extends ChessPiece {
	
	private final String WHITE_PATH = "/resources/pieces/r_w.png";
	private final String BLACK_PATH = "/resources/pieces/r_b.png";
	
	public Rook(int x, int y, boolean color, Board board) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'r';
		this.board = board;
		if (board.isMainBoard())
			try {
				if (color)
					this.image = ImageIO.read(getClass().getResource(BLACK_PATH));
				else
					this.image = ImageIO.read(getClass().getResource(WHITE_PATH));
			} catch (Exception e){
				System.out.println("Error: Could not load piece resource! " + this.type);
			}
		board.getBoardArray()[x][y].setPiece(this);
	}
	
	@Override
	public ArrayList<Coordinate> getPossibleMoves() {
		ArrayList<Coordinate> movesList = new ArrayList<Coordinate>();
		
		// up
		for (int i = y+1; i <= 8; i++) {
			if (board.getBoardArray()[x][i].hasPiece()) {
				if (this.color != board.getBoardArray()[x][i].getPiece().getColor()) {
					movesList.add(new Coordinate(x, i));
				}
				break;
			} else {
				movesList.add(new Coordinate(x, i));
			}
		}
		
		//down
		for (int i = y-1; i >= 1; i--) {
			if (board.getBoardArray()[x][i].hasPiece()) {
				if (this.color != board.getBoardArray()[x][i].getPiece().getColor()) {
					movesList.add(new Coordinate(x, i));
				}
				break;
			} else {
				movesList.add(new Coordinate(x, i));
			}
		}
		
		
		//left
		for (int i = x+1; i <= 8; i++) {
			if (board.getBoardArray()[i][y].hasPiece()) {
				if (this.color != board.getBoardArray()[i][y].getPiece().getColor()) {
					movesList.add(new Coordinate(i, y));
				}
				break;
			} else {
				movesList.add(new Coordinate(i, y));
			}
		}
		
		//right
		for (int i = x-1; i >= 1; i--) {
			if (board.getBoardArray()[i][y].hasPiece()) {
				if (this.color != board.getBoardArray()[i][y].getPiece().getColor()) {
					movesList.add(new Coordinate(i, y));
				}
				break;
			} else {
				movesList.add(new Coordinate(i, y));
			}
		}
		return movesList;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}

	@Override
	public boolean isNull() {
		return false;
	}
	
}