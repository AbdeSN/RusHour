package fr.iutvalence.hassaineambry.rushhour;
/**
 * Element to move on the grid.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */
public class Car {
	/** Coordinate. */
	private Coordinate coordinate;
	/** Orientation. */
	private final Orientation orientation;
	/** Color. */
	private final Color color;
	/** Size of the car. */
	private final int carSize;
	
	public Car(Coordinate coordinate, Orientation orientation, int carSize, Color color) {
		this.coordinate = coordinate;
		this.orientation = orientation;
		this.color = color;
		this.carSize = carSize;
	}

	/** Get the car size. */
	public int size() {
		return this.carSize;
	}
	/** Get the car size. */
	public Orientation orientation() {
		return this.orientation;
	}
	/** Get the color of size. */
	public Color color() {
		return this.color;
	}
	
	public void setPosition(Coordinate coord) {
		this.coordinate = coord;
	}
	
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
