package fr.xebia.mowitnow.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import junit.framework.TestCase;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class CoordinatesTest extends TestCase {
	
	Coordinates coordinates = new Coordinates(3, 2);
	Surface surface = new Surface(5, 5);
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Coordinates#Coordinates(int, int)}.
     */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeCooridnates() {
		new Coordinates(-2, 2);
		new Coordinates(1, -2);
	}
	
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Coordinates#forwardAbciss()}.
     */
	@Test
	public void testForwardAbciss() {
		coordinates.forwardAbciss();
		assertEquals(4,coordinates.getAbciss());
	}

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Coordinates#forwardOrdinate()}.
     */
	@Test
	public void testForwardOrdinate() {
		coordinates.forwardOrdinate();
		assertEquals(3,coordinates.getOrdinate());
	}

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Coordinates#backwardAbciss()}.
     */
	@Test
	public void testBackwardAbciss() {
		coordinates.backwardAbciss();
		assertEquals(2,coordinates.getAbciss());
	}

	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Coordinates#backwardOrdinate()}.
     */
	@Test
	public void testBackwardOrdinate() {
		coordinates.backwardOrdinate();
		assertEquals(1,coordinates.getOrdinate());
	}
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Coordinates#equals(Object)}.
     */
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
