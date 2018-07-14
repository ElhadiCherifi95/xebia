package fr.xebia.mowitnow.model;

import org.junit.Test;

import fr.xebia.mowitnow.enumeration.Orientation;
import junit.framework.TestCase;

public class PositionTest extends TestCase {

	@Test
	public void testEquals() {
		Coordinates coordinates = new Coordinates(3, 2);
		Position position = new Position(coordinates, Orientation.EAST);
		
		Position positionCompared;
		
		positionCompared = new Position(coordinates, Orientation.EAST);
		assertEquals(true,position.equals(positionCompared));
		
		positionCompared = new Position(coordinates, Orientation.NORTH);
		assertEquals(false,position.equals(positionCompared));
		
		coordinates = new Coordinates(3, 5);
		
		positionCompared = new Position(coordinates, Orientation.EAST);
		assertEquals(false,position.equals(positionCompared));
		
		
		
	}


}
