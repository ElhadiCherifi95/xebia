package fr.xebia.mowitnow.enumeration;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.xebia.mowitnow.model.Coordinates;
import fr.xebia.mowitnow.model.Position;

public class ControlTest {

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.enumeration.Control#getControl(String)}.
     */
	@Test
	public void testGetControl() {
		assertNull(Control.getControl((null)));
        assertNull(Control.getControl(""));
        assertNull(Control.getControl("Z"));
        assertEquals(Control.D, Control.getControl("D"));
        assertEquals(Control.G, Control.getControl("G"));
        assertEquals(Control.A, Control.getControl("A"));
	}

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.enumeration.Control#apply(Position)}.
     */
	@Test
	public void testApply() {
		Position position = new Position(new Coordinates(1, 2), Orientation.E);
		 assertEquals(new Position(new Coordinates(1, 2), Orientation.S), Control.getControl("D").apply(position));
		 assertEquals(new Position(new Coordinates(1, 2), Orientation.N), Control.getControl("G").apply(position));
		 assertEquals(new Position(new Coordinates(2, 2), Orientation.E), Control.getControl("A").apply(position));
	     
	}

	

}
