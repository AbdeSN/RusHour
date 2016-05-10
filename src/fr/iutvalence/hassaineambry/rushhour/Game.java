package fr.iutvalence.hassaineambry.rushhour;

import java.util.InputMismatchException;
import java.util.Scanner;

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
	 * @param player2 
	 */
	public Game(Player player, Level level) {
		grid = new Grid(level);
	}

	public void start() throws NoCarException, CarOutOfTheGridException, CarCollisionException, InvalidCoordinateException {
		System.out.println(grid.toString());
		Scanner sc = new Scanner(System.in);

		int turn = 0;
		while(!grid.victory())
		{
			// Get the input from the player
			Coordinate coord = getPlayerCoordinate(sc);
			System.out.println(coord);

			Direction direction = getPlayerDirection(sc);
			System.out.println(direction);

			grid.moveCars(coord, direction);	
			
			System.out.println(grid.toString());
			turn+=1;
			System.out.println("Turn : "+turn);
		}
		sc.close();
	}


	/**
	 * Asking a direction
	 */
	public static Direction getPlayerDirection(Scanner sc) {
		System.out.println("Please enter a direction (U,D,L or R):");
		return Direction.fromString(sc.nextLine());
	}

	private static Coordinate getPlayerCoordinate(Scanner sc) {
		System.out.println("Please enter a the coordinate of the car you want to move : ");
		return new Coordinate(sc.nextInt(), sc.nextInt());
	}
}
