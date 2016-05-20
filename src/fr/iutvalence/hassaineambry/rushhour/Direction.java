package fr.iutvalence.hassaineambry.rushhour;

public enum Direction {
	UP("U"),
	DOWN("D"),
	LEFT("L"),
	RIGHT("R"),
	NOTHING("N");
			
	private final String direction;
	
	private Direction(String str) {
		this.direction = str;
	}
	
	public static Direction fromString(String str) {
		switch (str) {
		case "U":
			return UP;
		case "D":
			return DOWN;
		case "L":
			return LEFT;
		case "R":
			return RIGHT;
		default:
			return NOTHING;
		}
	}
}
