package fr.xebia.mowitnow.model;

import org.junit.Test;

import junit.framework.TestCase;

public class SurfaceTest extends TestCase {
	
	

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Surface#isValidCoordinatesInSurface(Coordinates)}.
     */
	@Test
	public void testIsValidCoordinatesInSurfaceAbciss() {		
		Surface surface = new Surface(5, 5);
		assertEquals(false, surface.isValidCoordinatesInSurface(new Coordinates(6, 4)));
		assertEquals(false, surface.isValidCoordinatesInSurface(new Coordinates(4, 6)));
		assertEquals(true, surface.isValidCoordinatesInSurface(new Coordinates(5, 5)));
		assertEquals(true, surface.isValidCoordinatesInSurface(new Coordinates(2, 3)));
	}
	
	
}
