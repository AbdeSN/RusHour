package fr.iutvalence.hassaineambry.rushhour;

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
		grid = new Grid();
	}

	public void start() {
		int turn = 0;

		while(!grid.victory())
		{
			turn++;
			
			// Get the input from the player
			Coordinate coord = getPlayerCoordinate();
			
			//Direction direction = getPlayerDirection();
			
			//grid.moveCars(coord, direction);		
		}
	}

//	private Direction getPlayerDirection() {
//		return DROITE;
//	}

	private Coordinate getPlayerCoordinate() {
		return new Coordinate(0,0);
	}
}
