package com.devinhartzell.chess.board;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.NullPiece;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Square extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7287090345533630180L;
	
	private JPanel piecePanel;

	public ChessPiece piece = new NullPiece();
	public boolean color;
	public BufferedImage pieceImage;
	public BufferedImage blankImage;
	public boolean selected;
	//private Board board;
	
	public Square(int x, int y, boolean black) {

		setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		this.color = black;
		if (black)
			setBackground(Color.BLUE);
		else
			setBackground(Color.WHITE);
		
		this.setLocation((50 * x) - 50 , (50 * y) - 50);
		
		setSize(50, 50);
		
		try
		{
			this.blankImage = ImageIO.read(getClass().getResource("/resources/pieces/noPiece.png"));
		}
		catch (IOException e)
		{
			System.out.println("Could not load placeholder image");
		}
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!piece.getClass().equals(NullPiece.class))
				{
					System.out.println("called");
				
						
					for (int i=1; i<=8; i++)
					{
						for (int j=1; j<=8; j++)
						{
							Board.getBoardArray()[i][j].setHighlighted(false);
						}
					}
					
					for (Coordinate s : piece.getPossibleMoves())
					{
						System.out.println(s.getX() + " " + s.getY());
						Board.getBoardArray()[s.getX()][s.getY()].setHighlighted(true);
					}
					setSelected(true);
				}
			}
		});
		
		
		
		piecePanel = new JPanel() {

			private static final long serialVersionUID = 8620947713227289840L;

			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(blankImage, 0, 0, null);
			}
		};
		
		piecePanel.setSize(40, 40);
		piecePanel.setLocation(5, 5);
	}
	
	public void setSelected(boolean b)
	{
		this.selected = b;
	}
	
	public ChessPiece getPiece()
	{
		return piece;
	}
	
	public void setHighlighted(boolean b)
	{
		if (b)
			setBackground(Color.ORANGE);
		else
		{
			if (color)
				setBackground(Color.BLUE);
			else
				setBackground(Color.WHITE);
			
		}
	}	
	
	public void setPiece(ChessPiece piece)
	{
		this.piece = piece;
		if (!piece.getClass().equals(NullPiece.class))
		{
			pieceImage = piece.getImage();
		}
		else
		{
			piece = new NullPiece();
			pieceImage = blankImage;
		}
		
		repaint();
	}
	
	public boolean hasPiece()
	{
		return (piece.getClass().equals(NullPiece.class));
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(pieceImage, 5, 5, null);
	}
	
}