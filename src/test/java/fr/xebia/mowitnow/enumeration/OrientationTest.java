package fr.xebia.mowitnow.enumeration;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.xebia.mowitnow.model.Coordinates;

public class OrientationTest {

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.enumeration.Orientation#getOrientation(String)}.
     */
	@Test
	public void testGetOrientationString() {
		assertNull(Orientation.getOrientation(null));
        assertNull(Orientation.getOrientation(""));
        assertNull(Orientation.getOrientation("X"));
        assertEquals(Orientation.N, Orientation.getOrientation("N"));
        assertEquals(Orientation.E, Orientation.getOrientation("E"));
        assertEquals(Orientation.S, Orientation.getOrientation("S"));
        assertEquals(Orientation.W, Orientation.getOrientation("W"));
	}

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.enumeration.Orientation#forward(Coordinates)}.
     */
	@Test
	public void testForward() {
		assertEquals(new Coordinates(1, 3), Orientation.N.forward(new Coordinates(1, 2)));
        assertEquals(new Coordinates(2, 2), Orientation.E.forward(new Coordinates(1, 2)));
        assertEquals(new Coordinates(1, 1), Orientation.S.forward(new Coordinates(1, 2)));
        assertEquals(new Coordinates(0, 2), Orientation.W.forward(new Coordinates(1, 2)));
	
	}

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.enumeration.Orientation#next()}.
     */
	@Test
	public void testNext() {
		assertEquals(Orientation.N, Orientation.W.next());
        assertEquals(Orientation.E, Orientation.W.next().next());
        assertEquals(Orientation.S, Orientation.W.next().next().next());
        assertEquals(Orientation.W, Orientation.W.next().next().next().next());
	}

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.enumeration.Orientation#back()}.
     */
	@Test
	public void testBack() {
		assertEquals(Orientation.N, Orientation.E.back());
        assertEquals(Orientation.W, Orientation.E.back().back());
        assertEquals(Orientation.S, Orientation.E.back().back().back());
        assertEquals(Orientation.E, Orientation.E.back().back().back().back());
	}

}
