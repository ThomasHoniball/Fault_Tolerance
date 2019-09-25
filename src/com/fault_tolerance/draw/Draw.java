package com.fault_tolerance.draw;

import java.io.IOException;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TerminalSize;

import com.fault_tolerance.draw.AsciiGraphic;
import com.fault_tolerance.draw.AsciiComponent;

/**
 * The Draw class is responsible for output to the lanterna terminal. It SHOULD be used with ascii graphics to make the game interface
 */
public class Draw
{
	private Terminal terminal = null;
	private TextGraphics graphics = null;
	/**
	 * This constructor initialises the terminal in a new swing pane.
	 * @return 
	 */
	public Draw()
	{
		try{
			DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
			terminalFactory.setAutoOpenTerminalEmulatorWindow(true);
			terminalFactory.setInitialTerminalSize(new TerminalSize(200,200));
			terminal = terminalFactory.createTerminalEmulator();
			terminal.setCursorVisible(false);
			graphics = terminal.newTextGraphics();
		}catch(IOException e)
		{
			System.err.println("IOException on Draw Constructor");
		}
		
		// terminal.setVisible(true);
	}
	/**
	 * Close allows the terminal to be shut down 
	 */
	public void close()
	{
		try{
			terminal.close();
		}catch(IOException e)
		{
			System.err.println("IOException on Draw.close function");
		}
	}
	/**
	 * Prints out some handy debug data to the non-lanterna terminal.
	 */
	public void printDebug()
	{
		try{
			System.out.println("Size: " + terminal.getTerminalSize().toString());
			System.out.println("Cursor Location: " + terminal.getCursorPosition().toString());
		}catch(IOException e)
		{
			System.err.println("IO Exception on Draw.printDebug function");
		}
	}

	public void drawGraphic(AsciiGraphic graphic)
	{
		// drawGrid(graphic.getGrid());
		try{
			int termRow = terminal.getCursorPosition().getRow();
			int termColumn = terminal.getCursorPosition().getColumn();
			for (int i = 0; i < graphic.rows; i++) 
			{
				AsciiComponent[] row = graphic.getRow(i);
				for (int x = 0; x < row.length; x++) 
				{
					setTextColor(row[x].getColor());
					drawGrid(row[x].getComponentGrid());
				}
			}
		}catch(IOException e)
		{
			System.err.println("IO Exception on drawGraphic function");
		}
	}

	public void drawGraphic(AsciiGraphic graphic, int y, int x)
	{
		// drawGrid(graphic.getGrid(), y, x);
		try
		{
			terminal.setCursorPosition(x, y);
			drawGraphic(graphic);

		}catch(IOException e)
		{
			System.err.println("Error in DrawGraphic with coords");
		}
	}

	public void setTextColor(TextColor color)
	{
		graphics.setForegroundColor(color);
	}

	public void drawCharacter(char character, TextColor color)
	{
		TextColor original = graphics.getForegroundColor();
		graphics.setForegroundColor(color);
		drawCharacter(character);
		graphics.setForegroundColor(original);
	}
	public void drawCharacter(char character)
	{
		try
		{
			graphics.setCharacter(terminal.getCursorPosition() ,character);
			terminal.flush();
		}catch(IOException e)
		{
			System.err.println("Error in DrawCharacter");
		}
	}

	public void drawCharacter(char character, int y, int x)
	{
		try
		{
			terminal.setCursorPosition(x, y);
			drawCharacter(character);

		}catch(IOException e)
		{
			System.err.println("Error in DrawCharacter with coords");
		}
	}

	public void drawGrid(char[][] grid)
	{
		try
		{
			int termRow = terminal.getCursorPosition().getRow();
			int termColumn = terminal.getCursorPosition().getColumn();
			for (int y=0; y < grid.length; y++) 
			{
				terminal.setCursorPosition(termColumn, termRow + y);
				for (int x=0; x < grid[y].length; x++) 
				{
					terminal.setCursorPosition(termColumn + x, termRow + y);
					drawCharacter(grid[y][x]);
				}	
			}
			terminal.flush();
		}catch(IOException e)
		{
			System.err.println("IOEXCEPTION in drawGrid");
		}
	}

	public void drawGrid(char[][] grid, int y, int x)
	{
		try
		{
			terminal.setCursorPosition(x, y);
			drawGrid(grid);

		}catch(IOException e)
		{
			System.err.println("Error in DrawGrid with coords");
		}
	}
}