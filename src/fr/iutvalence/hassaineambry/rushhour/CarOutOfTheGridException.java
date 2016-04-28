package fr.iutvalence.hassaineambry.rushhour;

public class CarOutOfTheGridException extends Exception {

	/**
	 * Boundary error
	 */
	public CarOutOfTheGridException() {
		System.out.println("Stop ! It seems you try to get ouf the map !");
	}
}
