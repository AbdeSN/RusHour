package fr.iutvalence.hassaineambry.rushhour.levels;

import static fr.iutvalence.hassaineambry.rushhour.Color.*;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.*;

import java.util.LinkedList;
import java.util.List;

import fr.iutvalence.hassaineambry.rushhour.Car;
import fr.iutvalence.hassaineambry.rushhour.Coordinate;
import fr.iutvalence.hassaineambry.rushhour.Level;

/**
* Create level one by placing car on grid.
*
* @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
* @version 1.0
*/

/**
 * Create the first level 
 */
public class Level2 implements Level 
{
	/**
	 * Create a list of cars
	 */
	@Override
	public List<Car> createCar()
	{
		final List<Car> car = new LinkedList<>();
		car.add(new Car(new Coordinate(1, 0), HORIZONTAL, 3, GREEN));
		car.add(new Car(new Coordinate(1, 4), VERTICAL, 3, YELLOW));
		car.add(new Car(new Coordinate(2, 1), HORIZONTAL, 2, RED));
		car.add(new Car(new Coordinate(2, 5), VERTICAL, 2, BLUE));
		car.add(new Car(new Coordinate(3, 2), VERTICAL, 2, ORANGE));
		car.add(new Car(new Coordinate(4, 4), HORIZONTAL, 2, PINK));
		car.add(new Car(new Coordinate(5, 0), HORIZONTAL, 3, WHITE));
		return car;
	}
	
	/**
	 * Get the exit coordinate
	 */
    @Override
	public Coordinate getExit() {
        Coordinate exitCoordinate = new Coordinate(2, 5);
		return exitCoordinate;
    }
}


