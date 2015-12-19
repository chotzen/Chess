package com.devinhartzell.chess;

import java.awt.Composite;
import java.awt.Graphics;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.devinhartzell.chess.board.Board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class ChessGameWindow extends JFrame {
	

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1109205743042597274L;

	public ChessGameWindow(ChessGame game) throws IOException
	{
		getContentPane().setLayout(null);
		
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(418, 39, 162, 367);
		getContentPane().add(textArea);
		
		JLabel lblRecentMoves = new JLabel("Recent Moves");
		lblRecentMoves.setBounds(418, 11, 86, 16);
		getContentPane().add(lblRecentMoves);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(579, 39, 15, 367);
		getContentPane().add(scrollBar);
		//final BufferedImage image = ImageIO.read(getClass().getResource("/resources/a.jpg"));

		/*
		JPanel board = new JPanel() {
			
			private static final long serialVersionUID = 6329003120785353635L;

			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(image, 0, 0, null);
			}
		};
		
		*/
		//board.setBounds(6, 6, 401, 400);
		//getContentPane().add(board);
		
		this.setSize(621, 449);
		this.setVisible(true);
		
		
		Board board = new Board();
		board.setLocation(6, 6);
		
		getContentPane().add(board);
		
	}
	
	@PostConstruct
	public void createControls(Composite parent)
	{
		
	}
}
