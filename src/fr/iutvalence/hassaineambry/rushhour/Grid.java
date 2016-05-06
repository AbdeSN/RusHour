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
public class Grid {
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


    /** Create the grid. 
     * @param level */
    public Grid(Level level) {
        height = GRID_LINES;
        width = GRID_COLUMNS;
        grid = new Car[GRID_LINES][GRID_COLUMNS];

        //Adding cars !!
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
  
    // XXX
    /**
    * Get the grid coordinates
    * @param coordinate
    */ 
    public Car getGridCoord(Coordinate coordinate)
 	{
 		return this.grid[coordinate.getX()][coordinate.getY()];
 	}

    // XXX
    /**
     * Put cars on the grid
     * @param coordinate 
     * @param car
     */
    public void putCar(Coordinate coordinate, Car car) {
    	// XXX
    	this.grid[coordinate.getX()][coordinate.getY()] = null;
	}
     
    /**
     * Move the car from a position to an other
     * 
     * @param initialCoords
     * @param numberOfMovements
     * @throws CarOutOfTheGridException
     * @throws CarCollisionException
     * @throws InvalidCoordinateException
     */
    public void moveCars(Coordinate initialCoords, Direction numberOfMovements) throws NoCarException, CarOutOfTheGridException, CarCollisionException, InvalidCoordinateException 
    {
    	if (initialCoords.getX() > 5 || initialCoords.getY() > 5 || initialCoords.getX() < 0 || initialCoords.getX() < 0) 
    		throw new InvalidCoordinateException("The coordinate must be between 0 et 5");
    	
    	Car car = getGridCoord(initialCoords);
    	
    	/** We're looking for a car */
    	if (car == DEFAULT_CELL) throw new NoCarException ("Oops, no car here !");
    	
  
    		/** We watch in what position is the car */
    	    if(car.orientation() == Orientation.HORIZONTAL) 
    	    {
    	    	
    	    	if (car.coordinate().getX() + 1 >= GRID_COLUMNS) throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
    	    	
    	    	if (car.coordinate().getX() == -1) throw new CarCollisionException("There is a car here !");
    	    	
    	    	for (int i = 0; i < grid.length; i++) {
    				Coordinate newCoordinates = new Coordinate(car.coordinate().getX(), car.coordinate().getY());
    				//Return newCoordinates 
    			}
    	    }
    	    else
    	    {
    	    	if (car.coordinate().getX() + 1 >= GRID_LINES) throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
    	    	
    	    	if (car.coordinate().getX() == -1) throw new CarCollisionException("There is a car here !");
    	    	
    	    	for (int i = 0; i < grid.length; i++) {
    				Coordinate newCoordinates = new Coordinate(car.coordinate().getX(), car.coordinate().getY());
    				//Return newCoordinates
    			}
    	    }
		
    	
    }
    
    /**
     * Victory
     * @return
     */
    public boolean victory() {
		// TODO Auto-generated method stub
		return false;
	}
    
    /**
     * Print the grid
     */
    @Override
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
