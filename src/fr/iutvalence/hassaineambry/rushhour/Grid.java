package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Color.*;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.HORIZONTAL;

import java.util.LinkedList;
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
    private final Coordinate exit;

    /** Create the grid and add car on it
     * @param level 
     * 
     */
    public Grid(Level level) {
        height = GRID_LINES;
        width = GRID_COLUMNS;
        grid = new Car[GRID_LINES][GRID_COLUMNS];

        final List<Car> cars = level.createCar();
        exit = level.getExit();
        
        //Generate the grid empty
        for (int i = 0; i < GRID_LINES; i++) {
            for (int j = 0; j < GRID_COLUMNS; j++) {
                grid[i][j] = DEFAULT_CELL;
            }
        }
        
        //Add cars on it
        for (Car car : cars) {
			Coordinate origin = car.coordinate();
			Orientation orientation = car.orientation();
			int size = car.size();

			if (orientation == Orientation.HORIZONTAL) {
				for (int i = origin.getX(); i < origin.getX() + size; i++) {
					if (size == 3) {
						putCar(car.coordinate().getX(), car.coordinate().getY(), car);
						putCar(car.coordinate().getX(), car.coordinate().getY() + 1, car);
						putCar(car.coordinate().getX(), car.coordinate().getY() + 2, car);
					}
					else {
						putCar(car.coordinate().getX(), car.coordinate().getY(), car);
						putCar(car.coordinate().getX(), car.coordinate().getY() + 1, car);
					}
				}
			}
			else {
				for (int j = origin.getY(); j < origin.getY() + size; j++) {
					if (size == 3) {
						putCar(car.coordinate().getX(), car.coordinate().getY(), car);
						putCar(car.coordinate().getX() + 1, car.coordinate().getY(), car);
						putCar(car.coordinate().getX() + 2, car.coordinate().getY(), car);
					}
					else {
						putCar(car.coordinate().getX(), car.coordinate().getY(), car);
						putCar(car.coordinate().getX() + 1, car.coordinate().getY(), car);
					}
				}
			}
        }
        
        
    }

    /**
     * Put cars on the grid
     * @param coordinate 
     * @param car
     */
    public void putCar(int x, int y, Car car) {
    	this.grid[x][y] = car;

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


 
     
    /**
     * Move the car from a position to an other.
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
    	if (car.equals(DEFAULT_CELL)) throw new NoCarException ("Oops, no car here !");
    	
  
    		/** We watch in what position is the car */
    	    if(car.orientation().equals(Orientation.HORIZONTAL)) 
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
    public boolean victory(){
       	return false;
	}
    /**
     * Print the grid
     */
//    public String toPrint (){
//    	StringBuilder line = new StringBuilder (GRID_LINES + GRID_COLUMNS +1);
//    	return line.toPrint();
//    }
    public String toString() {
    	
        StringBuilder represente = new StringBuilder (GRID_LINES + GRID_COLUMNS +1);
        represente.append("[ ] [0] [1] [2] [3] [4] [5]");
        represente.append(System.getProperty("line.separator"));
        
        for (int i = 0; i < GRID_LINES; i++) {
        	represente.append("["+i+"] ");
            for (int j = 0; j < GRID_COLUMNS; j++) {
                represente.append(grid [i][j]);
            }
            represente.append(System.getProperty("line.separator"));
        }
        
        return represente.toString();
    }
    
}
