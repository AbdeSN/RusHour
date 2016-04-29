package fr.iutvalence.hassaineambry.rushhour;

import java.util.List;

public interface Level {
	/**
	 * Get the car list
	 * 
	 * @return
	 */
	List<Car> createCar();
	
	/**
	 * Get the exit
	 */
	Coordinate getExit();
}
