package fr.iutvalence.hassaineambry.rushhour;
/**
 * Enumeration of all kind of car color.
 *
 * @author HASSAINE Abderrahmane/AMBRY Maxime/TP1B
 * @version v1.0
 */

/**
 * Enumeration all of kind of colors.
 */

public enum Color {
	/**
	 * Listing of colors.
	 */
   RED ("R"),
   GREEN ("G"),
   BLUE ("B"),
   YELLOW ("Y"),
   PINK ("P"),
   ORANGE ("O"),
   WHITE ("W"),
   ZERO ("Z");
   private String color = "";
   
   /**
    * Constructor
    */
   Color(String color){
	   this.color = color;
   }
   /**
    * Method
    */
   public String toString(){
	    return color;
   }
   /**
    * Get the color
    */
   public String getColor() {
	   return color;
   }
}

