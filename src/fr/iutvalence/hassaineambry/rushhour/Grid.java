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
	private  Car[][] grid;



	/** Create the grid and add car on it
	 * @param level 
	 * 
	 */
	public Grid(Level level) {
		height = GRID_LINES;
		width = GRID_COLUMNS;
		grid = new Car[GRID_LINES][GRID_COLUMNS];


		List<Car> cars = level.createCar();

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
	public void moveCars(Coordinate askCoords, Direction direction) throws NoCarException, CarOutOfTheGridException, CarCollisionException, InvalidCoordinateException, MoveForbidenException 
	{
		Car car = getGridCoord(askCoords);
		Coordinate initialCoords = car.coordinate();
		Coordinate finalCoords = new Coordinate(0,0);
		
		Coordinate newFullCoords =  new Coordinate(0,0);
		Coordinate leavedCoords = new Coordinate(0,0);


		if (initialCoords.getX() > 5 || initialCoords.getY() > 5 || initialCoords.getX() < 0 || initialCoords.getY() < 0) 
			throw new InvalidCoordinateException("The coordinate must be between 0 et 5");


		/** We're looking for a car */
		if (car.equals(DEFAULT_CELL)) throw new NoCarException ("Oops, no car here !");

		/** We watch the position of the car */
		if(car.orientation() == Orientation.HORIZONTAL) 
		{
			/** We chose which direction is available for the car */
			if (direction == Direction.UP || direction == Direction.DOWN) 
				throw new MoveForbidenException("This movement is forbiden");
			
			/** We watch if there is no car at coordinates creating by the direction*/
			if (direction == Direction.LEFT) {
				finalCoords = new Coordinate(initialCoords.getX(),initialCoords.getY() - 1);
				leavedCoords = new Coordinate(initialCoords.getX(), initialCoords.getY() + car.size() - 1);
				newFullCoords = finalCoords;
				
				/** We watch if the car will go out of the grid with his new coordinates */
				if (finalCoords.getY() < 0) 
					throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
				
				/** We watch if the car will go against another car */
				if (this.grid[finalCoords.getX()][finalCoords.getY()] != DEFAULT_CELL) 
					throw new CarCollisionException("There is a car here !");
			}
			else {
				finalCoords = new Coordinate(initialCoords.getX(),initialCoords.getY() + 1);
				leavedCoords = initialCoords;
				newFullCoords = new Coordinate(initialCoords.getX(), initialCoords.getY() + car.size());
				
				/** We watch if the car will go out of the grid with his new coordinates */
				if (finalCoords.getY() >= GRID_LINES) 
					throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
				
				/** We watch if the car will go against another car */
				if (this.grid[finalCoords.getX()][initialCoords.getY() + car.size()] != DEFAULT_CELL) 
					throw new CarCollisionException("There is a car here !");
			}
		}
		else
		{
			/** We chose which direction is available for the car */
			if (direction == Direction.RIGHT || direction == Direction.LEFT) 
				throw new MoveForbidenException("This movement is forbiden");
			else {
				
				/** We watch if there is no car at coordinates creating by the direction*/
				if (direction == Direction.UP) {
					finalCoords = new Coordinate(initialCoords.getX() - 1,initialCoords.getY());
					leavedCoords = new Coordinate(initialCoords.getX() + car.size() - 1, initialCoords.getY());
					newFullCoords = finalCoords;
					
					/** We watch if the car will go out of the grid with his new coordinates */
					if (finalCoords.getX() < 0) 
						throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
					
					/** We watch if the car will go against another car */
					if (this.grid[finalCoords.getX()][finalCoords.getY()] != DEFAULT_CELL) 
						throw new CarCollisionException("There is a car here !");
				}
				else {
					finalCoords = new Coordinate(initialCoords.getX() + car.size(),initialCoords.getY());
					leavedCoords = initialCoords;
					newFullCoords = finalCoords;
					
					/** We watch if the car will go out of the grid with his new coordinates */
					if (finalCoords.getX() >= GRID_COLUMNS) 
						throw new CarOutOfTheGridException("Where are you going ? You're out of the map !");
					
					/** We watch if the car will go against another car */
					if (this.grid[finalCoords.getX()][finalCoords.getY()] != DEFAULT_CELL) 
						throw new CarCollisionException("There is a car here !");
				}
			}
		}

		this.grid[newFullCoords.getX()][newFullCoords.getY()] = car;
		this.grid[leavedCoords.getX()][leavedCoords.getY()] = DEFAULT_CELL;
		car.setPosition(finalCoords);
		System.out.println(finalCoords);

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

