package fr.iutvalence.hassaineambry.rushhour;

public enum Direction {
	TOP("U"),
	BOTTOM("D"),
	LEFT("L"),
	RIGHT("R"),
	NOTHING("N");
			
	private final String direction;
	
	private Direction(String str) {
		this.direction = str;
	}
	
	public static Direction fromString(String str) {
		for (Direction direction : Direction.values()) {
			if(direction.equals(str));
				return direction;
		}
		return NOTHING;
	}
}