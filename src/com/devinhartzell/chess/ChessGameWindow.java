package com.devinhartzell.chess;

import java.awt.Composite;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.devinhartzell.chess.board.Board;

import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class ChessGameWindow extends JFrame {
	

	/**
	 * 
	 */
	private JLabel whiteLabel;
	private JLabel blackLabel;
	private static JLabel moveLabel;
	private static final long serialVersionUID = 1109205743042597274L;

	public ChessGameWindow(ChessGame game, String white, String black) throws IOException
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
		
		this.setSize(621, 475);
		this.setVisible(true);
		
		whiteLabel = new JLabel(String.format("White: %s", white));
		whiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		whiteLabel.setBounds(6, 418, 150, 16);
		getContentPane().add(whiteLabel);
		
		blackLabel = new JLabel(String.format("Black: %s", black));
		blackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blackLabel.setBounds(262, 418, 150, 16);
		getContentPane().add(blackLabel);
		
		moveLabel = new JLabel("White to move");
		moveLabel.setBounds(428, 418, 114, 16);
		getContentPane().add(moveLabel);
		
		
		Board board = new Board();
		board.setLocation(6, 6);
		
		getContentPane().add(board);
		
	}
	
	@PostConstruct
	public void createControls(Composite parent)
	{
		
	}
	
	public static void nextMove()
	{
		if (Board.currentMove)
			moveLabel.setText("Black to move");
		else
			moveLabel.setText("White to move");
	}
	
}
