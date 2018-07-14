package fr.xebia.mowitnow.model;

import org.junit.Test;
import junit.framework.TestCase;


public class CoordinatesTest extends TestCase {
	
	Coordinates coordinates = new Coordinates(3, 2);
	Surface surface = new Surface(5, 5);
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNegativeCooridnatesAbciss() {
		new Coordinates(2, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeCooridnatesOrdinate() {
		new Coordinates(1, -2);
	}

	@Test
	public void testForwardAbciss() {
		coordinates.forwardAbciss();
		assertEquals(4,coordinates.getAbciss());
	}

	@Test
	public void testForwardOrdinate() {
		coordinates.forwardOrdinate();
		assertEquals(3,coordinates.getOrdinate());
	}

	@Test
	public void testBackwardAbciss() {
		coordinates.backwardAbciss();
		assertEquals(2,coordinates.getAbciss());
	}

	@Test
	public void testBackwardOrdinate() {
		coordinates.backwardOrdinate();
		assertEquals(1,coordinates.getOrdinate());
	}
	
	@Test
	public void testEquals() {
		Coordinates coordinates = new Coordinates(3, 2);
		Coordinates coordinatesCompared;
		
		coordinatesCompared = new Coordinates(3, 2);
		assertEquals(true,coordinates.equals(coordinatesCompared));
		
		coordinatesCompared = new Coordinates(3, 5);
		assertEquals(false,coordinates.equals(coordinatesCompared));
	}

	

}
