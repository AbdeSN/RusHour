package fr.iutvalence.hassaineambry.rushhour;

/**
 * Enumeration of all kind of car color.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version 1.0
 */
public enum Color {
    /** TODO. */
    RED("R"),
    /** TODO. */
    GREEN("G"),
    /** TODO. */
    BLUE("B"),
    /** TODO. */
    LIGHT_BLUE("LB"),
    /** TODO. */
    YELLOW("Y"),
    /** TODO. */
    PINK("P"),
    /** TODO. */
    ORANGE("O"),
    /** TODO. */
    WHITE("W"),
    /** TODO. */
    ZERO("Z");

    /** TODO. */
    private String color = "";

    /** TODO. */
    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}

