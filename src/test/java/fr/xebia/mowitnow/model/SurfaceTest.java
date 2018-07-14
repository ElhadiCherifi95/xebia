package fr.xebia.mowitnow.model;

import org.junit.Test;

import junit.framework.TestCase;

public class SurfaceTest extends TestCase {
	
	Surface surface = new Surface(5, 5);

	@Test
	public void testIsValidCoordinatesInSurfaceAbciss() {		
		assertEquals(false, surface.isValidCoordinatesInSurface(new Coordinates(6, 4)));
	}
	
	@Test
	public void testIsValidCoordinatesInSurfaceOrdinate() {		
		assertEquals(false, surface.isValidCoordinatesInSurface(new Coordinates(4, 6)));
	}
	
	@Test
	public void testIsValidCoordinatesInSurfaceMaxCoordinates() {		
		assertEquals(true, surface.isValidCoordinatesInSurface(new Coordinates(5, 5)));
	}
	
	@Test
	public void testIsValidCoordinatesInSurface() {		
		assertEquals(true, surface.isValidCoordinatesInSurface(new Coordinates(2, 3)));
	}
}
