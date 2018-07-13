package fr.xebia.mowitnow.model;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import fr.xebia.mowitnow.enumeration.Control;
import fr.xebia.mowitnow.enumeration.Orientation;
import junit.framework.TestCase;

public class Mowertest extends TestCase {
	
	Position initialPosition= new Position(new Coordinates(1, 2),Orientation.NORTH);
	Surface initialSurface = new Surface(new Coordinates(5, 5));
	Queue<Control> queueControles = new LinkedList<Control>();
	
	
	@Test
	public void testApplyForward() {
		queueControles.add(Control.FORWARD);
		Mower mower = new Mower(initialPosition, initialSurface ,queueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(3, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.NORTH, mower.getPosition().getOrientation());

	}
	
	@Test
	public void testApplyLeft() {
		queueControles.add(Control.LEFT);
		Mower mower = new Mower(initialPosition, initialSurface ,queueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(2, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.WEST, mower.getPosition().getOrientation());

	}
	
	@Test
	public void testApplyRight() {
		queueControles.add(Control.RIGHT);
		Mower mower = new Mower(initialPosition, initialSurface ,queueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(2, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.EAST, mower.getPosition().getOrientation());

	}
	
	@Test
	public void testApplyCombinedComands() {
		//GAGAGAGAA
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.FORWARD);
		Mower mower = new Mower(initialPosition, initialSurface ,queueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(3, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.NORTH, mower.getPosition().getOrientation());

	}

}
