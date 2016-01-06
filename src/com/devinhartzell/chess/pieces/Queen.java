package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

public class Queen extends ChessPiece {
	
	private final String WHITE_PATH = "/resources/pieces/r_w.png";
	private final String BLACK_PATH = "/resources/pieces/r_b.png";
	
	public Queen(int x, int y, boolean color) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'r';
		try {
			if (color)
				this.image = ImageIO.read(getClass().getResource(BLACK_PATH));
			else
				this.image = ImageIO.read(getClass().getResource(WHITE_PATH));
			
			Board.getBoardArray()[x][y].setPiece(this);
		} catch (Exception e) {
			System.out.println("Error: Could not load rook resource");
		}
	}
	
	@Override
	public ArrayList<Coordinate> getPossibleMoves() {
		ArrayList<Coordinate> movesList = new ArrayList<Coordinate>();
		
		int[] xc = {x, x+1, x+1, x+1, x, x-1, x-1, x-1};
		int[] yc = {y+1, y+1, y, y-1, y-1, y-1, y, y+1};
		
		for (int i = 0; i <= 7; i++) {
			int testx = this.x;
			int testy = this.y;
			while (true) {
				testx += xc[i];
				testy += yc[i];
				if (testx <= 8 && testx >= 1 && testy <=8 && testy >= 1) {
					if (Board.getBoardArray()[testx][testy].hasPiece()) {
						if (Board.getBoardArray()[testx][testy].getPiece().getColor() != this.color) {
							movesList.add(new Coordinate(xc[i], yc[i]));
						} else {
							break;
						}
					} else {
						movesList.add(new Coordinate(xc[i], yc[i]));
					}
				} else {
					break;
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