package com.fault_tolerance.draw;
import com.fault_tolerance.draw.AsciiComponent;

/**
 * This class combines Ascii Components together to draw complex elements
 */
public class AsciiGraphic
{
	private AsciiComponent[][] blocks;
	private int currentRow;
	public int rows;

	/**
	 * Sets the currentrow to 0 (first index) and creates the blocks element with one empty item
	 * @return 
	 */
	public AsciiGraphic()
	{
		currentRow = 0;
		rows = 1;
		blocks = new AsciiComponent[1][];
	}

	/**
	 * Adds a component to the current row of the graphic
	 * @param component The component to add
	 */
	public void addComponent(AsciiComponent component)
	{
		if(blocks[currentRow] == null)
		{
			blocks[currentRow] = new AsciiComponent[1];
		}else
		{
			AsciiComponent[] newRow = new AsciiComponent[blocks[currentRow].length+1];
			for (int i = 0; i < blocks[currentRow].length; i++) 
			{
				newRow[i] = blocks[currentRow][i];	
			}
			blocks[currentRow] = newRow;
		}

		blocks[currentRow][blocks[currentRow].length-1] = component;

	}

	/**
	 * Increment Current Rows and increase Blocks size.
	 */
	public void addRow()
	{
		rows++;
		AsciiComponent[][] newBlocks = new AsciiComponent[rows][];
		for (int i = 0; i > blocks.length; i++) 
		{
			newBlocks[i] = blocks[i];	
		}
		blocks = newBlocks;
	}

	public void nextRow()
	{
		currentRow++;
	}

	public char[][] getGrid()
	{
		char[][] grid = new char[1][0];
		int row = 0;
		// System.out.println(blocks[0][0].toString());
		for (int i = 0; i < blocks.length; i++) 
		{
			char[][] gridRow = getRowGrid(blocks[i]);
			grid = resizeY(grid, gridRow.length);
			for (int y = 0; y < gridRow.length; y++) 
			{
				if(gridRow[y].length > grid[0].length)
				{
					grid = resizeX(grid, gridRow[y].length);
				}
				for (int x = 0; x < gridRow[y].length; x++) 
				{
					grid[row][x] = gridRow[y][x];		
				}	
				row++;
			}
		}
		return grid;
	}

	public AsciiComponent[] getRow(int row)
	{
		return blocks[row];
	}

	public char[][] getRowGrid(AsciiComponent[] row)
	{
		char[][] grid = new char[1][0];
		int column = 0;
		for (int i = 0; i < row.length; i++) 
		{
			char[][] block = row[i].getComponentGrid();
			grid = resizeX(grid, grid[0].length + block[0].length);
			if(block.length > grid.length)
			{
				grid = resizeY(grid, block.length);
			}
			for (int x = 0; x < block[0].length; x++) 
			{

				
				for (int y = 0; y < block.length; y++) {
					grid[y][column] = block[y][x];
				}
				column++;
			}
		}
		return grid;
	}

	private char[][] resizeY(char[][] arr, int length)
	{
		char[][] newArr = new char[length][];
		for (int i = 0; i < arr.length; i++) 
		{
			newArr[i] = arr[i];	
		}
		newArr[newArr.length-1] = new char[newArr[0].length];
		return newArr;
	}

	private char[][] resizeX(char[][] arr, int length)
	{
		char[][] newArr = new char[arr.length][];
		for (int i = 0; i < arr.length; i++) 
		{
			newArr[i] = resizeArr(arr[i], length);	
		}
		return newArr;
	}

	private char[] resizeArr(char[] arr, int length)
	{
		char[] newArr = new char[length];
		for (int i = 0; i < arr.length; i++) 
		{
			newArr[i] = arr[i];	
		}
		return newArr;
	}

}