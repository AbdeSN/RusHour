package fr.iutvalence.hassaineambry.rushhour;

import java.util.Scanner;

import fr.iutvalence.hassaineambry.rushhour.exceptions.CarCollisionException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.CarOutOfTheGridException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.InvalidCoordinateException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.MoveForbidenException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.NoCarException;

/**
 * Generate the game, with the grid and cars.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version 1.0
 */
public class Game {
	private final Grid grid;
	/** 
	 * Initialize the game. 
	 * @param level 
	 * @param player
	 */
	public Game(Player player, Level level) {
		grid = new Grid(level);
	}

	public void start() throws NoCarException, CarOutOfTheGridException, CarCollisionException, InvalidCoordinateException, MoveForbidenException {
		System.out.println(grid.toString());
		Scanner sc = new Scanner(System.in);

		int turn = 0;
		while(!grid.victory())
		{
			// Get the input from the player
			turn+=1;
			System.out.println("Turn : "+turn);
			
			Coordinate coord = getPlayerCoordinate(sc);
			System.out.println(coord);
			sc.nextLine();

			Direction direction = getPlayerDirection(sc);
			System.out.println(direction);

			grid.moveCars(coord, direction);
			
			System.out.println(grid.toString());
			
		}
		sc.close();
	}


	/**
	 * Asking a direction
	 * @param sc, the input scanned
	 */
	public static Direction getPlayerDirection(Scanner sc) {
		System.out.println("Please enter a direction (U,D,L or R):");
		return Direction.fromString(sc.nextLine());
	}

	/**
	 * Asking the car we want to move
	 * @param sc, the input scanned
	 */
	private static Coordinate getPlayerCoordinate(Scanner sc) {
		System.out.println("Please enter the coordinate of the car you want to move : ");
		return new Coordinate(sc.nextInt(), sc.nextInt());
	}
}
