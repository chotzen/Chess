package com.devinhartzell.chess.board;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.NullPiece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.border.LineBorder;

public class Square extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7287090345533630180L;
	
	private JPanel piecePanel;
	
	private int x, y;

	private ChessPiece piece = new NullPiece(this.getX(), this.getY());
	private boolean color;
	private BufferedImage blankImage;
	private boolean selected;
	
	private static boolean disableGraphicChanges = false;
	
	private Graphics g;
	//private Board board;
	
	public Square(final int x, final int y, boolean black) {
		
		this.color = black;
		if (black)
			setBackground(Color.BLUE);
		else
			setBackground(Color.WHITE);
		
		this.setLocation((50 * x) - 50 , (50 * y) - 50);
		
		setSize(50, 50);
		
		try {
			this.blankImage = ImageIO.read(getClass().getResource("/resources/pieces/noPiece.png"));
		}
		catch (IOException e) {
			System.out.println("Could not load placeholder image");
		}
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (piece.type != '0' && !getBackground().equals(Color.ORANGE) && piece.getColor() == Board.getTurn()) {
					//System.out.println("called");
				
						
					for (int i=1; i<=8; i++) {
						for (int j=1; j<=8; j++) {
							Board.getBoardArray()[i][j].setHighlighted(false);
							Board.getBoardArray()[i][j].setSelected(false);
							Board.getBoardArray()[i][j].repaint();
							Board.getBoardArray()[i][j].revalidate();
						}
					}
					
					for (Coordinate s : piece.getPossibleMoves()){
						if (piece.getType() == 'k')
							System.out.println(s.getX() + " " + s.getY());
						Board.getBoardArray()[s.getX()][s.getY()].setHighlighted(true);
					}
					setSelected(true);
				}
				
				if (getBackground().equals(Color.ORANGE)) {
					if (piece.getClass().equals(NullPiece.class)) {
						piece.kill();
					}
					
					for (int i = 1; i <= 8; i++) {
						for (int j = 1; j <= 8; j++) {
							if (Board.getBoardArray()[i][j].selected) {
								Board.getBoardArray()[i][j].getPiece().move(x, y);
								Board.getBoardArray()[i][j].repaint();
								
							}
						}
					}
				}
			}
		});
		
		
		
		piecePanel = new JPanel() {

			private static final long serialVersionUID = 8620947713227289840L;

			@Override
			protected void paintComponent(Graphics g) {
				if (!disableGraphicChanges) {
					super.paintComponent(g);
					g.drawImage(blankImage, 0, 0, null);
				}
			}
		};
		
		piecePanel.setSize(40, 40);
		piecePanel.setLocation(5, 5);
	}
	
	public void setSelected(boolean b) {
		this.selected = b;
	}
	
	public ChessPiece getPiece() {
		return piece;
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
		
		repaint();
		revalidate();
	}	
	
	public void setPiece(ChessPiece newpiece) {		
		this.piece = newpiece;
		g.drawImage(piece.getImage(), 5, 5, null);
		repaint();
		revalidate();
		
		//System.out.println(this.piece.toString());
	}
	
	public boolean hasPiece() {
		return !piece.isNull();
	}
	
	public static void setDisabledGraphics(boolean b) {
		Square.disableGraphicChanges = b;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		this.g = g;
		try {
			super.paintComponent(g);
			g.drawImage(piece.getImage(), 5, 5, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void repaint() {
		this.repaint();
		piecePanel.repaint();
	}
	
	@Override
	public void revalidate() {
		this.revalidate();
		piecePanel.revalidate();
	}
	
	
}