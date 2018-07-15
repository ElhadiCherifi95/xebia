package fr.xebia.mowitnow.model;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import fr.xebia.mowitnow.enumeration.Control;
import fr.xebia.mowitnow.enumeration.Orientation;
import junit.framework.TestCase;

public class Mowertest extends TestCase {
	
	Position initialPosition= new Position(new Coordinates(1, 2),Orientation.N);
	Surface initialSurface = new Surface(5, 5);
	Queue<Control> initialQueueControles = new LinkedList<Control>();
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Mower#apply()}.
     */
	@Test
	public void testApplyForward() {
		initialQueueControles.add(Control.A);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(3, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.N, mower.getPosition().getOrientation());

	}
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Mower#apply()}.
     */
	@Test
	public void testApplyLeft() {
		initialQueueControles.add(Control.G);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(2, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.W, mower.getPosition().getOrientation());

	}
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Mower#apply()}.
     */
	@Test
	public void testApplyRight() {
		initialQueueControles.add(Control.D);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(2, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.E, mower.getPosition().getOrientation());

	}
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Mower#apply()}.
     */
	@Test
	public void testApplyCombinedComands() {
		//GAGAGAGAA
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.A);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(3, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.N, mower.getPosition().getOrientation());

	}
	
	/**
     * Méthode de test pour {@link fr.xebia.mowitnow.model.Mower#equals(Object)}.
     */
	@Test
	public void testEqualsMower() {
		//GAGAGAGAA
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.G);
		initialQueueControles.add(Control.A);
		initialQueueControles.add(Control.A);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		Mower mowerCompared = new Mower(initialPosition, initialSurface ,initialQueueControles);
		//Same composant
		assertEquals(true, mower.equals(mowerCompared));
		
		//Different initial position
		Position position = new Position(new Coordinates(1, 2),Orientation.E);
		mowerCompared = new Mower(position, initialSurface ,initialQueueControles);
		assertEquals(false, mower.equals(mowerCompared));
		
		//Different surface
		Surface surface = new Surface(6, 5);
		mowerCompared = new Mower(initialPosition, surface ,initialQueueControles);
		assertEquals(false, mower.equals(mowerCompared));
		
		//Different controls
		Queue<Control> queueControles = new LinkedList<Control>();
		queueControles.add(Control.G);		
		mowerCompared = new Mower(initialPosition, initialSurface ,queueControles);
		assertEquals(false, mower.equals(mowerCompared));
	}
	

	
	
	

}
