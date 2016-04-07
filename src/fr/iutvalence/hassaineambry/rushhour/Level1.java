package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Color.GREEN;
import static fr.iutvalence.hassaineambry.rushhour.Color.RED;
import static fr.iutvalence.hassaineambry.rushhour.Color.YELLOW;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.HORIZONTAL;

// TODO Use interface !

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Level1 {
    /** TODO. */
    Car newCar1 = new Car(new Coordinate(0, 1), HORIZONTAL, 3, GREEN);
    /** TODO. */
    Car newCar2 = new Car(new Coordinate(1, 3), HORIZONTAL, 2, YELLOW);
    /** TODO. */
    Car newCar3 = new Car(new Coordinate(0, 1), HORIZONTAL, 3, RED);

    public void getExit() {
        Coordinate exitCoordinate = new Coordinate(5, 2);
    }
}

