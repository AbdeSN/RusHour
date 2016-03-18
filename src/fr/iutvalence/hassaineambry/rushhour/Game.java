package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Orientation.*;
import static fr.iutvalence.hassaineambry.rushhour.Color.*;

/**
 * Generate the game, with the grid and cars.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */
public class Game {

    /** Player's score. */
    private int turn;

    public int getTurn() {
		return turn;
	}

	/** Initialize the game. */
    public Game() {
    	Grid newGrid = new Grid();
    	Car newCar1 = new Car(new Coordinate(0, 1), HORIZONTAL, 3, GREEN);
    }
}
