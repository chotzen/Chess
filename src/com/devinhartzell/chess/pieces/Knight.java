package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

public class Knight extends ChessPiece {
	
	private final String WHITE_PATH = "/resources/pieces/n_w.png";
	private final String BLACK_PATH = "/resources/pieces/n_b.png";
	
	public Knight(int x, int y, boolean color, Board board) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'n';
		this.board = board;
		try {
			if (color)
				this.image = ImageIO.read(getClass().getResource(BLACK_PATH));
			else
				this.image = ImageIO.read(getClass().getResource(WHITE_PATH));
			if (board.isMainBoard())
				board.getBoardArray()[x][y].setPiece(this);
		}
		catch (Exception e) {
			System.out.println("Error: Could not load knight resource");
		}
	}
	
	@Override
	public ArrayList<Coordinate> getPossibleMoves() {
		ArrayList<Coordinate> movesList = new ArrayList<Coordinate>();
		
		int[] xc = {x+1, x+1, x-1, x-1, x+2, x-2, x+2, x-2};
		int[] yc = {y+2, y-2, y+2, y-2, y+1, y+1, y-1, y-1};
		
		for (int i = 0; i <= xc.length-1; i++)
		{
			if (xc[i] <= 8 && xc[i] >= 1 && yc[i] <=8 && yc[i] >= 1) {
				if (board.getBoardArray()[xc[i]][yc[i]].hasPiece()) {
					if (board.getBoardArray()[xc[i]][yc[i]].getPiece().getColor() != this.color) {
						movesList.add(new Coordinate(xc[i], yc[i]));
					}
				} else {
					movesList.add(new Coordinate(xc[i], yc[i]));
				}
			}
		} return movesList;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}

	@Override
	public boolean isNull() {
		return false;
	}
	
}