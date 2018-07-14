package fr.xebia.mowitnow.model;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import fr.xebia.mowitnow.enumeration.Control;
import fr.xebia.mowitnow.enumeration.Orientation;
import junit.framework.TestCase;

public class Mowertest extends TestCase {
	
	Position initialPosition= new Position(new Coordinates(1, 2),Orientation.NORTH);
	Surface initialSurface = new Surface(5, 5);
	Queue<Control> initialQueueControles = new LinkedList<Control>();
	
	
	@Test
	public void testApplyForward() {
		initialQueueControles.add(Control.FORWARD);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(3, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.NORTH, mower.getPosition().getOrientation());

	}
	
	@Test
	public void testApplyLeft() {
		initialQueueControles.add(Control.LEFT);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(2, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.WEST, mower.getPosition().getOrientation());

	}
	
	@Test
	public void testApplyRight() {
		initialQueueControles.add(Control.RIGHT);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(2, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.EAST, mower.getPosition().getOrientation());

	}
	
	@Test
	public void testApplyCombinedComands() {
		//GAGAGAGAA
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.FORWARD);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		mower.apply();
		assertEquals(1, mower.getPosition().getCoordinates().getAbciss());
		assertEquals(3, mower.getPosition().getCoordinates().getOrdinate());
		assertEquals(Orientation.NORTH, mower.getPosition().getOrientation());

	}
	
	@Test
	public void testEqualsMower() {
		//GAGAGAGAA
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.LEFT);
		initialQueueControles.add(Control.FORWARD);
		initialQueueControles.add(Control.FORWARD);
		Mower mower = new Mower(initialPosition, initialSurface ,initialQueueControles);
		Mower mowerCompared = new Mower(initialPosition, initialSurface ,initialQueueControles);
		assertEquals(true, mower.equals(mowerCompared));
		
		Position position = new Position(new Coordinates(1, 2),Orientation.EAST);
		mowerCompared = new Mower(position, initialSurface ,initialQueueControles);
		assertEquals(false, mower.equals(mowerCompared));
		
		Surface surface = new Surface(6, 5);
		mowerCompared = new Mower(initialPosition, surface ,initialQueueControles);
		assertEquals(false, mower.equals(mowerCompared));
		
		Queue<Control> queueControles = new LinkedList<Control>();
		queueControles.add(Control.LEFT);		
		mowerCompared = new Mower(initialPosition, initialSurface ,queueControles);
		assertEquals(false, mower.equals(mowerCompared));
	}
	

	
	
	

}
