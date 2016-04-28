package fr.iutvalence.hassaineambry.rushhour;

public class CarCollisionException extends Exception {
	
	/**
	 * Collision error
	 */
	public CarCollisionException() {
		System.out.println("Oops ! You just rush into a another car");
	}
}
