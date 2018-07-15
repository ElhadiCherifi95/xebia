package fr.xebia.mowitnow.model;

import org.junit.Test;

import fr.xebia.mowitnow.enumeration.Orientation;
import junit.framework.TestCase;

public class PositionTest extends TestCase {

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Position#equals(Object)}.
     */
	@Test
	public void testEquals() {
		Coordinates coordinates = new Coordinates(3, 2);
		Position position = new Position(coordinates, Orientation.E);
		
		Position positionCompared;
		
		positionCompared = new Position(coordinates, Orientation.E);
		assertEquals(true,position.equals(positionCompared));
		
		positionCompared = new Position(coordinates, Orientation.N);
		assertEquals(false,position.equals(positionCompared));
		
		coordinates = new Coordinates(3, 5);
		
		positionCompared = new Position(coordinates, Orientation.E);
		assertEquals(false,position.equals(positionCompared));	
		
	}


}
