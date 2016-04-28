package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Color.ZERO;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.HORIZONTAL;

import java.util.List;


/**
 * Generate the grid.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version 1.0
 */
public abstract class Grid {
    /** Height of the grid. */
    public static final int GRID_LINES   = 6;
    /** Lenght of the grid. */
    public static final int GRID_COLUMNS = 6;
    /** Default cell to initializing the grid. */
    public static final Car DEFAULT_CELL = new Car(new Coordinate(-1, -1), HORIZONTAL, 1, ZERO);
   
    
    
    /** Lines number of the grid. */
    private final int     height;
    /** Columns number of the grid. */
    private final int     width;
    /** Board fill of car. */
    private final Car[][] grid;
    

    /** Create the grid. */
    public Grid() {
        height = GRID_LINES;
        width = GRID_COLUMNS;
        grid = new Car[GRID_LINES][GRID_COLUMNS];

        for (int i = 0; i < GRID_LINES; i++) {
            for (int j = 0; j < GRID_COLUMNS; j++) {
                grid[i][j] = DEFAULT_CELL;
            }
        }
    }

    /** Get the number of columns. */
    public int width() {
        return this.width;
    }

    /** Get the number of lines. */
    public int height() {
        return this.height;
    }
    
    /**
     * Creating cars
     */
    protected abstract List<Car> createCar();
    

   /**
    * Get the grid coordinates
    * @param coordinate
    */ 
    public Car getGridCoord(Coordinate coordinate)
 	{
 		return this.grid[coordinate.getX()][coordinate.getY()];
 	}

    /**
     * Put cars on the grid
     * @param coordinate 
     * @param car
     */
    public void putcar(Coordinate coordinate, Car car) {
    	this.getGridCoord(coordinate).setCar(car);
	}
     
    /**
     * Move cars
     */
    public void moveCars() throws CarOutOfTheGridException, CarCollisionException, InvalidCoordinateException 
    {
	    
    }
    /**
     * Print the grid
     */
    public String toString() {
    	
        StringBuilder represente = new StringBuilder (GRID_LINES + GRID_COLUMNS +1);
        for (int i = 0; i < GRID_LINES; i++) {
            for (int j = 0; j < GRID_COLUMNS; j++) {
                represente.append(grid [i][j]);
            }
            represente.append(System.getProperty("line.separator"));
        }
        return represente.toString();
    }
}
