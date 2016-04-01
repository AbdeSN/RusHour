package fr.iutvalence.hassaineambry.rushhour;

import static fr.iutvalence.hassaineambry.rushhour.Color.GREEN;
import static fr.iutvalence.hassaineambry.rushhour.Color.RED;
import static fr.iutvalence.hassaineambry.rushhour.Color.YELLOW;
import static fr.iutvalence.hassaineambry.rushhour.Orientation.HORIZONTAL;

public class Level1 {
	
	Car newCar1 = new Car(new Coordinate(0, 1), HORIZONTAL, 3, GREEN);
	Car newCar2 = new Car(new Coordinate(1, 3), HORIZONTAL, 2, YELLOW);
	Car newCar3 = new Car(new Coordinate(0, 1), HORIZONTAL, 3, RED);
	
	//public Coordinate getCar() {
		
	//}
	
	public void getExit() {
		Coordinate exitCoordinate = new Coordinate(5,2);
	}

}

