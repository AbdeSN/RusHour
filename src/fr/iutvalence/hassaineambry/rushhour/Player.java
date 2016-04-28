package fr.iutvalence.hassaineambry.rushhour;

/**
 * Creation of a player for the score.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version 1.0
 */
public class Player {
    /** Name of player. */
    private final String name;

    /** Create a player. */
    public Player(String name) {
        this.name = name;
    }

    /** Get the player name. */
    public String getName() {
        return name;
    }
}
