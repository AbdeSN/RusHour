package fr.iutvalence.hassaineambry.rushhour;

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
		// Generating the grid and cars on it
    	// Player player = new Player("Gelibert");
		
		
		//Add a level in parameter 
		grid = new Grid(level);
		grid.toString();
	}

	public void start() {
		int turn = 0;

		while(!grid.victory())
		{
			turn+=1;
			
			// Get the input from the player
			Coordinate coord = getPlayerCoordinate();
	    	System.out.println(coord);
			
			Direction direction = getPlayerDirection();
	    	System.out.println(direction);
			
			//grid.moveCars(coord, direction);		
		}
	}

	public Direction getPlayerDirection() {
		
		/**
		 * Asking a direction
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a direction (T,B,L or R):");
		String str = sc.nextLine();
		sc.close();
    	
		switch (str) {
		case "T":
			Direction top = new Direction(str); 
			return top;
		case "B":
			Direction bottom = new Direction(str); 
			return bottom;
		case "L":
			Direction left = new Direction(str); 
			return left;
		case "R":
			Direction right = new Direction(str); 
			return right;
		}
		return null;
	}

	private Coordinate getPlayerCoordinate() {
		return new Coordinate(0,0);
	}
}
