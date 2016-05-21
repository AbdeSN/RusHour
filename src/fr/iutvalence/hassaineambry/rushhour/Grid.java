package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Color.*;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.HORIZONTAL;

import java.util.List;

import fr.iutvalence.hassaineambry.rushhour.exceptions.CarCollisionException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.CarOutOfTheGridException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.InvalidCoordinateException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.MoveForbidenException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.NoCarException;


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

    /** Create the grid and add car on it
     * @param level 
     * 
     */
    public Grid(Level level) {
        height = GRID_LINES;
        width = GRID_COLUMNS;
        grid = new Car[GRID_LINES][GRID_COLUMNS];

        final List<Car> cars = level.createCar();
        
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
						for (int j = 0; j < 3; j++) {
							putCar(car.coordinate().getX(), car.coordinate().getY() + j, car);
						}
					}
					else {
						for (int j = 0; j < 2; j++) {
							putCar(car.coordinate().getX(), car.coordinate().getY() + j, car);
						}
					}
				}
			}
			else {
				for (int j = origin.getY(); j < origin.getY() + size; j++) {
					if (size == 3) {
						for (int k = 0; k < 3; k++) {
							putCar(car.coordinate().getX() + k, car.coordinate().getY(), car);
						}
					}
					else {
						for (int k = 0; k < 2; k++) {
							putCar(car.coordinate().getX() + k, car.coordinate().getY(), car);
						}
					}
				}
			}
        }
    }
    
    public Grid(Level level, Car newCar) {
        height = GRID_LINES;
        width = GRID_COLUMNS;
        grid = new Car[GRID_LINES][GRID_COLUMNS];

        final List<Car> cars = level.createCar();
        
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

			for (int indexL = 0; indexL < GRID_LINES; indexL++) {
	            for (int indexC = 0; indexC < GRID_COLUMNS; indexC++) {
	            	if (car.color() == newCar.color()) {
		            	if (orientation == Orientation.HORIZONTAL) {
		    				for (int i = origin.getX(); i < origin.getX() + size; i++) {
		    					if (size == 3) {
		    						for (int j = 0; j < 3; j++) {
		    							putCar(newCar.coordinate().getX(), newCar.coordinate().getY() + j, newCar);
		    						}
		    					}
		    					else {
		    						for (int j = 0; j < 2; j++) {
		    							putCar(newCar.coordinate().getX(), newCar.coordinate().getY() + j, newCar);
		    						}
		    					}
		    				}
		    			}
		    			else {
		    				for (int j = origin.getY(); j < origin.getY() + size; j++) {
		    					if (size == 3) {
		    						for (int k = 0; k < 3; k++) {
		    							putCar(newCar.coordinate().getX() + k, newCar.coordinate().getY(), newCar);
		    						}
		    					}
		    					else {
		    						for (int k = 0; k < 2; k++) {
		    							putCar(newCar.coordinate().getX() + k, newCar.coordinate().getY(), newCar);
		    						}
		    					}
		    				}
		    			}
	            	}
	            	else {
	            		if (orientation == Orientation.HORIZONTAL) {
	        				for (int i = origin.getX(); i < origin.getX() + size; i++) {
	        					if (size == 3) {
	        						for (int j = 0; j < 3; j++) {
	        							putCar(car.coordinate().getX(), car.coordinate().getY() + j, car);
	        						}
	        					}
	        					else {
	        						for (int j = 0; j < 2; j++) {
	        							putCar(car.coordinate().getX(), car.coordinate().getY() + j, car);
	        						}
	        					}
	        				}
	        			}
	        			else {
	        				for (int j = origin.getY(); j < origin.getY() + size; j++) {
	        					if (size == 3) {
	        						for (int k = 0; k < 3; k++) {
	        							putCar(car.coordinate().getX() + k, car.coordinate().getY(), car);
	        						}
	        					}
	        					else {
	        						for (int k = 0; k < 2; k++) {
	        							putCar(car.coordinate().getX() + k, car.coordinate().getY(), car);
	        						}
	        					}
	        				}
	        			}
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
  
  
    /**
    * Get the car coordinates on the grid
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
     * @param direction
     * @throws CarOutOfTheGridException
     * @throws CarCollisionException
     * @throws InvalidCoordinateException
     */
    public Car moveCars(Coordinate initialCoords, Direction direction) throws NoCarException, CarOutOfTheGridException, CarCollisionException, InvalidCoordinateException, MoveForbidenException 
    {
    	if (initialCoords.getX() > 5 || initialCoords.getY() > 5 || initialCoords.getX() < 0 || initialCoords.getY() < 0) 
    		throw new InvalidCoordinateException("The coordinate must be between 0 et 5");
    	
    	Car car = getGridCoord(initialCoords);
    	Coordinate finalCoords = new Coordinate(0,0);
    	/** We're looking for a car */
    	if (car.equals(DEFAULT_CELL)) throw new NoCarException ("Oops, no car here !");
    	
    		/** We watch the position of the car */
    	    if(car.orientation() == Orientation.HORIZONTAL) 
    	    {
	    		/** We chose wich direction is available for the car */
    	    	if (direction == Direction.UP || direction == Direction.DOWN) 
    	    		throw new MoveForbidenException("This movement is forbiden");
    	    	else {
        	    	/** We watch if there is no car at coordinates creating by the direction*/
    	    		if (direction == Direction.LEFT) {
    	    	    	/** We watch if the car will go out of the grid with his new coordinates */
    	    			if (car.coordinate().getY() - 1 < 0) 
    	    				throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
    	    				/** We watch if the car will go against another car */
    						if (car.coordinate().getY() - 1 == DEFAULT_CELL.coordinate().getY()) 
    							throw new CarCollisionException("There is a car here !");
    						else {
    		    				finalCoords = new Coordinate(initialCoords.getX(), initialCoords.getY() - 1);
    						}
					}
    	    		else {
    	    			/** We watch if the car will go out of the grid with his new coordinates */
    	    			if (car.coordinate().getY() + car.size() >= GRID_LINES) 
    	    				throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
    	    				/** We watch if the car will go against another car */
    						if (car.coordinate().getY() + car.size() == DEFAULT_CELL.coordinate().getY()) 
    							throw new CarCollisionException("There is a car here !");
    						else {
    		    				finalCoords = new Coordinate(initialCoords.getX(), initialCoords.getY() + 1);
    						}
    	    		}
				}
    	    }
    	    else
    	    {
    	    	/** We chose wich direction is available for the car */
    	    	if (direction == Direction.RIGHT || direction == Direction.LEFT) 
    	    		throw new MoveForbidenException("This movement is forbiden");
    	    	else {
        	    	/** We watch if there is no car at coordinates creating by the direction*/
    	    		if (direction == Direction.UP) {
    	    	    	/** We watch if the car will go out of the grid with his new coordinates */
    	    			if (car.coordinate().getX() - 1 < 0) 
    	    				throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
    	    				/** We watch if the car will go against another car */
    						if (car.coordinate().getX() - 1 == DEFAULT_CELL.coordinate().getX()) 
    							throw new CarCollisionException("There is a car here !");
    						else {
    		    				finalCoords = new Coordinate(initialCoords.getX() - 1, initialCoords.getY());
    						}
					}
    	    		else {
    	    			/** We watch if the car will go out of the grid with his new coordinates */
    	    			if (car.coordinate().getX() + car.size() >= GRID_COLUMNS) 
    	    				throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
    	    				/** We watch if the car will go against another car */
    						if (car.coordinate().getX() + car.size() == DEFAULT_CELL.coordinate().getX()) 
    							throw new CarCollisionException("There is a car here !");
    						else {
    		    				finalCoords = new Coordinate(initialCoords.getX() + 1, initialCoords.getY());
    						}
    	    		}
				}
    	    }
			System.out.println(finalCoords);
			return new Car(finalCoords, car.orientation(), car.size(), car.color());
		
    	
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
