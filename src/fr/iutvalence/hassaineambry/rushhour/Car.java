package fr.iutvalence.hassaineambry.rushhour;
/**
 * Element to move on the grid.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */
public class Car {
	/** Coordinate. */
	public Coordinate coordinate;
	/** Orientation. */
	public Orientation orientation;
	/** Color. */
	public Color color;
	/** Size of the car. */
	private int carSize;
	
	public Car(Coordinate coordinate, Orientation orientation, int carSize, Color color) {
		this.coordinate = coordinate;
		this.orientation = orientation;
		this.color = color;
		this.carSize = carSize;
	}

	/** Get the car size. */
	public int getCarSize() {
		return this.carSize;
	}

}
