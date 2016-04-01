package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Color.ZERO;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.HORIZONTAL;

/**
 * Generate the grid.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */
public class Grid {
	public static final int GRID_LINES = 6;
	public static final int GRID_COLUMNS = 6;
	public static final Car DEFAULT_CELL = new Car(new Coordinate(-1, -1), HORIZONTAL, 1, ZERO);
	/**
	 * Lines number of the grid
	 */
	private final int height;
	/**
	 * Columns number of the grid.
	 */
	private final int width;
	
	private final Car[][] grid;
	
	public Grid() {
		height = GRID_LINES;
		width = GRID_COLUMNS;
		grid = new Car[GRID_LINES][GRID_COLUMNS];
		
	    for(int i = 0; i < GRID_LINES; i++)
	    {
	        for(int j = 0; j < GRID_COLUMNS; j++)
	        {
	            grid[i][j] = DEFAULT_CELL;
	        }
	    }
	}
	/** 
	 * Get the number of columns
	 * @return number of columns
     */
	public int width() {
		return this.width;
	}
	/**
	 * Get the number of lines
	 * @return number of lines
     */
	public int height() {
		return this.height;
	}
	
	@Override
	public String toString() {
		
	String represente = " ";
	 for(int i = 0; i < GRID_LINES; i++)
	    {
	        for(int j = 0; j < GRID_COLUMNS; j++)
	        {
	        	represente += "|";
	        }
	        represente += "-";
	    }
		return represente;
	}
	
}
