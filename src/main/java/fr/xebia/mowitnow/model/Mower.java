package fr.xebia.mowitnow.model;

import java.util.Iterator;
import java.util.Queue;

import fr.xebia.mowitnow.enumeration.Control;

/**
 * Classe de mapping d'une tondeuse
 * 
 * 
 * @author Elhadi CHERIFI
 */
public class Mower {
	
	//Position de la tondeuse
	private Position position;
	//Surface où se déplace la tondeuse
	private Surface surface;
	//Queue des différents control à exécuter 
	private Queue<Control> queueControles;
	
	/**
	 * Constructeur de la classe Mower (Tondeuse)
	 * @param position
	 * @param surface
	 * @param queueControles
	 */
	public Mower(Position position, Surface surface, Queue<Control> queueControles) {
		this.position = position;
		this.surface = surface;
		this.queueControles = queueControles;
	}
	
	
	/**
	 * Méthode qui applique les commandes sur la position initial d'une tondeuse et renvoie la position finale
	 *
	 * @return la dernière position d'une tondeuse après application des commandes
	 */
	public Position apply() {
		
		//Utilisation d'une position tampon
		Position tempPosition=new Position(position.getCoordinates(), position.getOrientation());
		Iterator<Control> waitingQueueIterator = queueControles.iterator();
        while (waitingQueueIterator.hasNext()) {
           
        	Control control = waitingQueueIterator.next();
            tempPosition=control.apply(tempPosition);
            
            //Si position tampon valide la nouvelle positione st assignée
            if(surface.isValidCoordinatesInSurface(tempPosition.getCoordinates()))
            	position=tempPosition;
            else
            	//Sinon on récupère la dernière position valide dans le tampon
            	tempPosition=position;
        }
        return position;
	};
	
	
	/**
	 * Getter de la queue des contrôles à appliquer à la tondeuse
	 * @return the queueControles
	 */
	public Queue<Control> getQueueControles() {
		return queueControles;
	}
	/**
	 * Setter de la queue des contrôles à appliquer à la tondeuse
	 * @param queueControles the queueControles to set
	 */
	public void setQueueControles(Queue<Control> queueControles) {
		this.queueControles = queueControles;
	}
	/**
	 * Getter de la position d'une tondeuse
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * Setter de la position d'une tondeuse
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * Getter de la surface d'une tondeuse
	 * @return the surface
	 */
	public Surface getSurface() {
		return surface;
	}
	/**
	 * Setter de la surface d'une tondeuse
	 * @param surface the surface to set
	 */
	public void setSurface(Surface surface) {
		this.surface = surface;
	}
	
	
	
}
