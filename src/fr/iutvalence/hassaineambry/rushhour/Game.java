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
    	
    	Grid newGrid = new Grid();
    	Level1 level1 = new Level1();
    	// Car[] cars = Level1.getCars();
    	level1.getExit();

		System.out.println(newGrid);
	}

	public void start() {
		/*while (Coordinate carCourant != Level1.getExit()) {
			// TODO Auto-generated method stub
		}*/
		
	}
	


}
