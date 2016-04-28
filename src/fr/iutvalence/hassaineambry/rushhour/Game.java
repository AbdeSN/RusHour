package fr.iutvalence.hassaineambry.rushhour;

/**
 * Generate the game, with the grid and cars.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version 1.0
 */
public class Game {
	/** Default score. */
    private static int DEFAULT_TURN = 0;
	/** Score. */
    private int turn;
    
    /** 
	 * Initialize the game. 
	 */
	public Game() {
		this.turn = DEFAULT_TURN;
    	Player player = new Player("Gelibert");

    	Level1 level1 = new Level1();
    	level1.getExit();

		System.out.println();
	}

	public void start() {
		
	}
	


}
