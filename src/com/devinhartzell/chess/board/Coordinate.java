package com.devinhartzell.chess.board;

public class Coordinate {
	
	public int x;
	public int y;
	
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean equals(Coordinate c)
	{
		return (this.x == c.getX() && this.y == c.getY());
	}

}
