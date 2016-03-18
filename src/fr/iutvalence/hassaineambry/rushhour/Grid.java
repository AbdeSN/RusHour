package fr.iutvalence.hassaineambry.rushhour;
/**
 * Generate the grid.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */
public class Grid {
	public static final int GRID_LINES = 6;
	public static final int GRID_COLUMNS = 6;
	/**
	 * Lines number of the grid
	 */
	private final int height;
	/**
	 * Columns number of the grid.
	 */
	private final int width;
	
	private final Cell[][] grid;
	
	public Grid() {
		height = GRID_LINES;
		width = GRID_COLUMNS;
		grid = new Cell[GRID_LINES][GRID_COLUMNS];
	}
	/** TODO.
	 *
	 * @return number of columns
     */
	public int Column() {
		return this.width;
	}
	/**
	 * TODO.
	 *
	 * @return TODO
     */
	public int Line() {
		return this.height;
	}

}
