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


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/*@Override
	public boolean equals(Object obj) {
		Mower mower= (Mower) obj;
		return mower.getSurface() ==this.surface && mower.getPosition() ==this.position && this.getQueueControles().equals(mower.getQueueControles());
	}*/

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((queueControles == null) ? 0 : queueControles.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mower other = (Mower) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (queueControles == null) {
			if (other.queueControles != null)
				return false;
		} else if (!queueControles.equals(other.queueControles))
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mower [position=" + position + ", surface=" + surface + ", queueControles=" + queueControles + "]";
	}
	
	
	
}
