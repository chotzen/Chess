package com.devinhartzell.chess.gui;

import java.awt.Composite;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.devinhartzell.chess.ChessGame;
import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.Pawn;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessGameWindow extends JFrame {
	

	/**
	 * 
	 */
	
	private JLabel whiteLabel;
	private JLabel blackLabel;
	private static JLabel moveLabel;
	private static final long serialVersionUID = 1109205743042597274L;
	
	private static JScrollPane scrollPane;
	private static JTextArea recentMoves;
	
	private static int turn = 1;
	
	private static char[] xrel = {'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	private static char[] yrel = {'0', '8', '7', '6', '5', '4', '3', '2', '1'};
	
	
	public ChessGameWindow(ChessGame game, String white, String black) 
			throws IOException {
		
		
		
		getContentPane().setLayout(null);
		
		recentMoves = new JTextArea();
		recentMoves.setText("");
		recentMoves.setEditable(false);
		
		scrollPane = new JScrollPane(recentMoves);
		scrollPane.setBounds(418, 39, 162, 367);
		getContentPane().add(scrollPane);
		
		JLabel lblRecentMoves = new JLabel("Recent Moves");
		lblRecentMoves.setBounds(418, 11, 86, 16);
		getContentPane().add(lblRecentMoves);
		
		this.setSize(621, 475);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		
		
		Board b = new Board(true);
		getContentPane().add(b.getBoardPanel());
		
		JButton btnNewBoard = new JButton("Duplicate");
		btnNewBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final Board test = new Board(ChessGame.getMainBoard());
				test.getBoardArray()[5][7].getPiece().move(5, 5);
				test.getBoardArray()[4][2].getPiece().move(4, 4);
				test.getBoardArray()[5][5].getPiece().move(4,4);
				test.print();
			}
		});
		btnNewBoard.setBounds(145, 413, 117, 29);
		getContentPane().add(btnNewBoard);
		
	}
	
	@PostConstruct
	public void createControls(Composite parent) {
		
	}
	
	public static void nextMove() {
		if (ChessGame.getMainBoard().currentMove)
			moveLabel.setText("Black to move");
		else
			moveLabel.setText("White to move");
	}
	
	
	public static void addMove(ChessPiece p, boolean capture) {
		String type = String.valueOf(Character.toUpperCase(p.getType()));
		if (p instanceof Pawn) { 
			System.out.println("hi");
			if (capture)
				type = String.valueOf(xrel[p.getOldX()]) + String.valueOf(yrel[p.getOldY()]);
			else	
				type = "";
		}
		if (!p.getColor()) {
			if (capture) 
				recentMoves.append(String.format("%s. %sx%s%s", turn, type, xrel[p.getX()], yrel[p.getY()]));
			 else 
				recentMoves.append(String.format("%s. %s%s%s", turn, type, xrel[p.getX()], yrel[p.getY()]));
		
		} else {
			if (capture) 
				recentMoves.append(String.format(" %sx%s%s\n", type, xrel[p.getX()], yrel[p.getY()]));
			else 
				recentMoves.append(String.format(" %s%s%s\n", type, xrel[p.getX()], yrel[p.getY()]));
			
			turn++;
		}
	}
}
