package fr.iutvalence.hassaineambry.rushhour;

import java.util.Scanner;
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
     */
    public static void main(final String[] args) {
        /**
         * Asking a name
         */
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter a name :");
    	String str = sc.nextLine();
    	sc.close();

    	Player player = new Player(str);
    	System.out.println(player.getName());
    	
    	/**
    	 * Asking a level number
    	 */
    	Scanner scLevel = new Scanner(System.in);
    	System.out.println("Enter a level :");
    	int lvl = scLevel.nextInt();
    	scLevel.close();
    	if(lvl == 1)
    	{
    		Level level = new Level1();
    	
    		Game playGame = new Game(player, level);
    		playGame.start();
    	}
    }
}
