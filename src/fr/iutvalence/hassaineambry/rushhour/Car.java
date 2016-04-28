package fr.iutvalence.hassaineambry.rushhour;

/**
 * Element to move on the grid.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version 1.0
 */
public class Car {
    /** Orientation. */
    private final Orientation orientation;
    /** Color. */
    private final Color       color;
    /** Size. */
    private final int         size;
    /** Coordinate. */
    private Coordinate  coordinate;

    /**
     * Create a car.
     *
     * @param coordinate  coordinate.
     * @param orientation orientation.
     * @param size        size.
     * @param color       color.
     */
    public Car(Coordinate coordinate, Orientation orientation, int size, Color color) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.color = color;
        this.size = size;
    }


    /** Get the car size. */
    public int size() {
        return this.size;
    }

    /** Get the car orientation. */
    public Orientation orientation() {
        return this.orientation;
    }

    /** Get the color of car. */
    public Color color() {
        return this.color;
    }
    /** Get the car coordinate. */
    public Coordinate coordinate() {
		return coordinate;
	}

    
    
    
	public void setPosition(Coordinate coord) {
        this.coordinate = coord;
    }
    
    public String toString()
	{
		return this.color.toString();
	}
    
    
    /**TODO method "toString"*/
    // public int Delta(){
        /*IF HORIZONTAL*/
			/*IF coordonn�e.x + 1 != Z OR coordon�e.x + 1 >= 6*/
    //Mouvement impossible (exception)
    		/* ELSE RETURN coordon�e.x + 1*/
			/*IF coordonn�e.x - 1 != Z OR coordon�e.x - 1 < 0*/
    //Mouvement impossible (exception)
    		/*ELSE RETURN coordon�e.x - 1*/
    	
    	/*IF VERTICAL*/
			/*IF coordonn�e.y + 1 != Z OR coordon�e.y + 1 >= 6*/
    //Mouvement impossible (exception)
    		/* ELSE RETURN coordon�e.y + 1*/
			/*IF coordonn�e.y - 1 != Z OR coordon�e.y - 1 < 0*/
    //Mouvement impossible (exception)
    		/*ELSE RETURN coordon�e.y - 1*/
    //}
}
