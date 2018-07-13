package fr.xebia.mowitnow.model;

import org.junit.Test;

import junit.framework.TestCase;

public class CoordinatesTest extends TestCase {
	
	Coordinates coordinates = new Coordinates(3, 2);
	Surface surface = new Surface(new Coordinates(5, 5));

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

	

}
