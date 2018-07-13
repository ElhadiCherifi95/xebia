package fr.xebia.mowitnow.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import fr.xebia.mowitnow.enumeration.Control;
import fr.xebia.mowitnow.enumeration.Orientation;
import fr.xebia.mowitnow.exceptions.FileContentException;
import fr.xebia.mowitnow.model.Coordinates;
import fr.xebia.mowitnow.model.Mower;
import fr.xebia.mowitnow.model.Position;
import fr.xebia.mowitnow.model.Surface;

/**
 * Classe de lecture du fichier initial et de préparation de l'environnement
 * 
 * 
 * @author Elhadi CHERIFI
 */
public class Reader {

	//Chemin du fichier à lire
	private String path;	
	//Queue des différentes à lire 
	private Queue<Mower> queueMowers;
	private BufferedReader br;

	/**
	 * Constructeur de la classe Reader
	 * @param path chemin du fichier à lire
	 */
	public Reader(String path) {
		this.path = path;
		queueMowers = new LinkedList<Mower>();
	}
	
	/**
	 * Méthode qui lit le fichier en entrée et en extrait la surface et la queue des tondeuses
	 * @return la queue des tondeuses
	 */
	public Queue<Mower> read() throws FileContentException {

		File file = new File(path);	

		try {
			br = new BufferedReader(new FileReader(file));

			String dimension = br.readLine();
			if (dimension == null) {
				throw new FileContentException("Le fichier d'entrée est vide");
			}

			String[] dimensions = dimension.split(" ");
			if (dimensions.length != 2) {
				throw new FileContentException("Les dimensions de la surface sont érronées (2 integer sont requis)");
			}

			Surface surface;
			try {
				surface = new Surface(new Coordinates(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1])));
			} catch (NumberFormatException e) {
				throw new FileContentException("Les dimensions de la surface sont érronées (2 integer sont requis)");
			}

			String position;
			String[] positions;
			String commands;
			Position initialPosition;
			Coordinates initialCoordinates;
			Orientation initialOrientation;
			Queue<Control> queueControles;
			while ((position = br.readLine()) != null) {
				positions = position.split(" ");
				commands = br.readLine();
				queueControles = new LinkedList<Control>();
				try {
					initialCoordinates = new Coordinates(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
				} catch (NumberFormatException e) {
					throw new FileContentException("La position initiale de la tondeuse X est érronnées (2 integer sont requis)");
				}

				initialOrientation=Orientation.getOrientation(positions[2]);			
				initialPosition = new Position(initialCoordinates, initialOrientation);
				for(String c : commands.split("")) {
					queueControles.add(Control.getOrientation(c));
				}

				queueMowers.add(new Mower(initialPosition, surface, queueControles));

			}



		} catch (IOException e) {

			e.printStackTrace();
		}

		return queueMowers;
	}

	/**
	 * Getter du chemin du fichier à lire
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Setter du chemin du fichier à lire
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Getter de la queue des tondeuses
	 * @return the queueMowers
	 */
	public Queue<Mower> getQueueMowers() {
		return queueMowers;
	}

	/**
	 * Setter de la queue des tondeuses
	 * @param queueMowers the queueMowers to set
	 */
	public void setQueueMowers(Queue<Mower> queueMowers) {
		this.queueMowers = queueMowers;
	}



}
