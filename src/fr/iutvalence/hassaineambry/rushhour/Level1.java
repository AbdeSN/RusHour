package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Color.*;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.*;

// TODO Use interface !

/**
 * Create level one by placing car on grid.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version 1.0
 */
public class Level1 implements Level{
	
    
    public Car[] getCars() {
    	
        /** Placing car number1 */
        Car newCar1 = new Car(new Coordinate(0, 1), HORIZONTAL, 3, GREEN);
        /** Placing car number2 */
        Car newCar2 = new Car(new Coordinate(1, 3), HORIZONTAL, 2, YELLOW);
        /** Placing car number3 */
        Car newCar3 = new Car(new Coordinate(2, 0), HORIZONTAL, 3, RED);
        /** Placing car number4 */
        Car newCar4 = new Car(new Coordinate(2, 5), VERTICAL, 3, BLUE);
        /** Placing car number5 */
        Car newCar5 = new Car(new Coordinate(2, 3), VERTICAL, 3, ORANGE);
        /** Placing car number6 */
        Car newCar6 = new Car(new Coordinate(2, 4), VERTICAL, 2, PINK);
        /** Placing car number7 */
        Car newCar7 = new Car(new Coordinate(3, 1), VERTICAL, 2, LIGHT_BLUE);
        /** Placing car number8 */
        Car newCar8 = new Car(new Coordinate(5, 2), HORIZONTAL, 3, WHITE);
		
        return null;

    }
    public Coordinate getExit() {
        Coordinate exitCoordinate = new Coordinate(2, 5);
		return exitCoordinate;
    }
}

