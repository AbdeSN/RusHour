package fr.iutvalence.hassaineambry.rushhour;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.iutvalence.hassaineambry.rushhour.exceptions.CarCollisionException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.CarOutOfTheGridException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.InvalidCoordinateException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.MoveForbidenException;
import fr.iutvalence.hassaineambry.rushhour.exceptions.NoCarException;
import fr.iutvalence.hassaineambry.rushhour.levels.Level1;
import fr.iutvalence.hassaineambry.rushhour.levels.Level2;
/**
 * TODO.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */

public class Rushhour {
    /**
     * Initializing the game.
     *
     * @param args TODO
     * @throws InvalidCoordinateException 
     * @throws CarCollisionException 
     * @throws CarOutOfTheGridException 
     * @throws NoCarException 
     */
    public static void main(final String[] args) throws NoCarException, CarOutOfTheGridException, CarCollisionException, InvalidCoordinateException, MoveForbidenException {
        /**
         * Asking a name
         */
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a name :");
		String str = sc.nextLine();
		
		Player player = new Player(str);
    	
    	/**
    	 * Asking a level number
    	 */
    	System.out.println("Enter a level (Level 1 or 2):");   	
    	int lvl = 0;
    	try {
    		lvl = sc.nextInt();
		} 
    	catch (InputMismatchException e) {
			System.out.println("typing error");
		}
    	catch (NumberFormatException e) {
			System.out.println("This level does not exist");
		}
    	
    	switch (lvl) {
		case 1:
    		Level level = new Level1();
    		Game playGame = new Game(player, level);
    		playGame.start();
			break;
//		case 2: 
//			Level level2 = new Level2();
//			Game playGame2 = new Game(player, level2);
//    		playGame2.start();
//			break;
//		default:
//			break;
		}
    	sc.close();

    }
}
