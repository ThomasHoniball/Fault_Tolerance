package com.fault_tolerance.draw;


/**
 * The AsciiComponent class stores the data for drawing pieces of an Ascii_Graphic. For example 1,2,'&' would be a component that draws as "&&"
 */
public class AsciiComponent
{
	private int rows, columns;
	private char character;

	public AsciiComponent(){

	}

	/**
	 * The all out constructor. Set it all! Set it now! Also probably best to use this as this class has no defaults.
	 * @param  _rows      The number of screen rows this component takes up
	 * @param  _columns   The number of screen columns this component takes up
	 * @param  _character The character used to fill the entity
	 * @return            
	 */
	public AsciiComponent(int _rows, int _columns, char _character)
	{
		rows = _rows;
		columns = _columns;
		character = _character;
	}

	/**
	 * Standard toString to unpack the object into plaintext
	 * @return A string with the object unpacked into columns with rows separated by \n
	 */
	public String toString()
	{
		String flatten = "";
		for (int y = 0; y < rows; y++) 
		{
			for (int x = 0; x < columns;x++ ) 
			{
				flatten += character;			
			}	
			if(y != rows-1)
			{
				flatten += "\n";
			}
		}
		return flatten;
	}

	/**
	 * This function builds a two dimensional grid to hold the layout of the component for outputting to the grid
	 * @return A block containing an array of rows, each containing the characters relevant to the block.
	 */
	public char[][]  getComponentGrid()
	{
		char [][] block = new char[rows][];
		for (int y = 0; y < rows; y++) 
		{
			char[] row = new char[columns];
			for (int x = 0; x < columns;x++ ) 
			{
				row[x] = character;			
			}
			block[y] = row;
		}
		return block;
	}

	public int getRows()
	{
		return rows;
	}

	public int getCols()
	{
		return columns;
	}

}