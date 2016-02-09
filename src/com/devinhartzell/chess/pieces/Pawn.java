package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

public class Pawn extends ChessPiece {
	
	private final String WHITE_PATH = "/resources/pieces/p_w.png";
	private final String BLACK_PATH = "/resources/pieces/p_b.png";
	
	public Pawn(int x, int y, boolean color, Board board) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'p';
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
		try{
		if (color) {
		
			if (y == 2)
				if (!board.getBoardArray()[x][4].hasPiece() && !board.getBoardArray()[x][3].hasPiece())
					movesList.add(new Coordinate(x, 4));
			if (y-1 >= 1)
				if (!board.getBoardArray()[x][y+1].hasPiece())
					movesList.add(new Coordinate(x, y+1));
			if (x+1 <= 8)
				if (board.getBoardArray()[x+1][y+1].hasPiece())
					if (!board.getBoardArray()[x+1][y+1].getPiece().getColor())
							movesList.add(new Coordinate(x+1, y+1));
			if (x-1 >= 1)
				if (board.getBoardArray()[x-1][y+1].hasPiece())
					if (!board.getBoardArray()[x-1][y+1].getPiece().getColor())
						movesList.add(new Coordinate(x-1, y+1));
		} else {
			if (y == 7)
				if (!board.getBoardArray()[x][5].hasPiece() && !board.getBoardArray()[x][6].hasPiece())
					movesList.add(new Coordinate(x, 5));
			
			if (y-1 <= 8)
				if (!board.getBoardArray()[x][y-1].hasPiece())
					movesList.add(new Coordinate(x, y-1));
			
			if (x+1 <= 8)
				if (board.getBoardArray()[x+1][y-1].hasPiece())
					if (board.getBoardArray()[x+1][y-1].getPiece().getColor())
						movesList.add(new Coordinate(x+1, y-1));
			
			
			if (x-1 >= 1)
				if (board.getBoardArray()[x-1][y-1].hasPiece())
					if (board.getBoardArray()[x-1][y-1].getPiece().getColor())
						movesList.add(new Coordinate(x-1, y-1));
		}} catch (Exception e){}
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