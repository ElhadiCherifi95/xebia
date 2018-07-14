package fr.xebia.mowitnow.tools;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import fr.xebia.mowitnow.enumeration.Control;
import fr.xebia.mowitnow.enumeration.Orientation;
import fr.xebia.mowitnow.exceptions.FileContentException;
import fr.xebia.mowitnow.model.Coordinates;
import fr.xebia.mowitnow.model.Mower;
import fr.xebia.mowitnow.model.Position;
import fr.xebia.mowitnow.model.Surface;

public class ReaderTest {
	
	 /**
     * Méthode de test pour {@link fr.xebia.mowitnow.tools.Reader}.
     * 
     * Test la levée de l'exception {@link fr.xebia.mowitnow.exceptions.FileContentException} en lisant un fichier vide
     * */
	@Test(expected = FileContentException.class)
	public void testReadEmptyFile() throws FileContentException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file/emptyFile.txt").getFile());
		new Reader(file.getPath()).read();
	}
	
	 
	 /**
     * Méthode de test pour {@link fr.xebia.mowitnow.tools.Reader}.
     * 
     * Lit un fichier de configuration test puis construit une queue de tondeuses équivalentes et vérifie l'égalité
     */
	@Test
	public void testReaderFile() throws FileContentException {
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file/mowitnow.txt").getFile());
		Reader reader = new Reader(file.getPath());		
		Queue<Mower> mowersQueueTest = new LinkedList<Mower>();
		
		Surface surface;
		Queue<Control> queueControles;
		Coordinates coordinates;
		Position position;
		Mower mower;
		/*
		 * 5 5
		 * 1 2 N
		 * GAGAGAGAA
		 * 3 3 E
		 * AADAADADDA
		*/
		surface = new Surface(5,5);
		coordinates = new Coordinates(1, 2);
		position = new Position(coordinates, Orientation.NORTH);
		queueControles = new LinkedList<Control>();
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.LEFT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.FORWARD);
		mower = new Mower(position, surface, queueControles );
		
		mowersQueueTest.add(mower);
		
		coordinates = new Coordinates(3, 3);
		position = new Position(coordinates, Orientation.EAST);
		queueControles = new LinkedList<Control>();
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.RIGHT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.RIGHT);
		queueControles.add(Control.FORWARD);
		queueControles.add(Control.RIGHT);
		queueControles.add(Control.RIGHT);
		queueControles.add(Control.FORWARD);
		mower = new Mower(position, surface, queueControles);

		mowersQueueTest.add(mower);
			
		assertEquals(reader.read(), mowersQueueTest);
		
		
	}

}
