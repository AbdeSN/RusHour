package fr.iutvalence.hassaineambry.rushhour;
/**
 * Enumeration of the two orientations available (horizontal / vertical).
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */
public enum Orientation {
	  HORIZONTAL("H"),
	  VERTICAL("V");
	  
   /** TODO. */
    private final String orientation;

    /** TODO. */
    Orientation(String orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return orientation;
    }

//	public boolean isCompatible(Direction direction) {
//		return (orientation == HORIZONTAL && direction == direction.UP) ||
//				(orientation == HORIZONTAL && direction == direction.DOWN) ||
//				(orientation == VERTICAL && direction == direction.LEFT) ||
//				(orientation == VERTICAL && direction == direction.RIGHT);
//	}
}
