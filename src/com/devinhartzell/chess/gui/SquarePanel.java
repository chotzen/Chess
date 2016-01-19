package com.devinhartzell.chess.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.devinhartzell.chess.ChessGame;
import com.devinhartzell.chess.board.Coordinate;
import com.devinhartzell.chess.board.Square;
import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.NullPiece;

public class SquarePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -976189580253215763L;

	private Square square;
	
	//private int x, y;
	private boolean color;
	
	private boolean selected;
	
	private Graphics g;
	
	public SquarePanel(int x, int y, boolean black) {
		setSize(50, 50);
		setLayout(null);
		if (black) {
			setBackground(Color.BLUE);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		
		this.square = ChessGame.getMainBoard().getBoardArray()[x][y];
		
		/*this.x = x;
		this.y = y;*/
		
		setLocation((50 * x) - 50 , (50 * y) - 50);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (square.getPiece().type != '0' && !getBackground().equals(Color.ORANGE) && square.getPiece().getColor() == ChessGame.getMainBoard().getTurn()) {
						
					for (int i=1; i<=8; i++) {
						for (int j=1; j<=8; j++) {
							ChessGame.getMainBoard().getBoardArray()[i][j].setHighlighted(false);
							ChessGame.getMainBoard().getBoardArray()[i][j].getPanel().setSelected(false);
							ChessGame.getMainBoard().getBoardArray()[i][j].getPanel().update();
						}
					}
					
					for (Coordinate s : square.getPiece().getPossibleMoves()){
						if (square.getPiece().getType() == 'k')
							System.out.println(s.getX() + " " + s.getY());
						ChessGame.getMainBoard().getBoardArray()[s.getX()][s.getY()].setHighlighted(true);
					}
					setSelected(true);
				}
				
				if (getBackground().equals(Color.ORANGE)) {
					if (square.getPiece() instanceof NullPiece) {
						square.getPiece().kill();
					}
					
					for (int i = 1; i <= 8; i++) {
						for (int j = 1; j <= 8; j++) {
							if (ChessGame.getMainBoard().getBoardArray()[i][j].getPanel().selected) {
								ChessGame.getMainBoard().getBoardArray()[i][j].getPiece().move(square.x, square.y);
								ChessGame.getMainBoard().getBoardArray()[i][j].getPanel().update();
								
							}
						}
					}
				}
			}
		});
	}
	
	
	public void setHighlighted(boolean b) {
		if (b) {
			setBackground(Color.ORANGE);
			setBorder(new LineBorder(new Color(0, 0, 128), 3));
		} else {
			if (color)
				setBackground(Color.BLUE);
			else
				setBackground(Color.WHITE);
			setBorder(new LineBorder(new Color(0, 0, 128), 0));
		}
		update();
	}	
	
	public void updatePiece(ChessPiece p) {
		try {
			if (square.getPiece().getType() == '0')
				g.drawImage(square.getPiece().getImage(), 5, 5, 1, 1, null);
			else
				g.drawImage(square.getPiece().getImage(), 5, 5, 40, 40, null);
		} catch (NullPointerException npe) {}
		repaint();
		revalidate();
	}
	
	public void update() {
		repaint();
		revalidate();
		repaint();
	}
	
	public void setSelected(boolean b) {
		this.selected = b;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		this.g = g;
		try {
			super.paintComponent(g);
			if (square.getPiece() instanceof NullPiece)
				g.drawImage(square.getPiece().getImage(), 5, 5, 1, 1, null);
			else
				g.drawImage(square.getPiece().getImage(), 5, 5, 40, 40, null);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}
	
	public Square getSquare() {
		return square;
	}
		
}
