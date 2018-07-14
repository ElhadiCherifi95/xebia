package fr.xebia.mowitnow.model;

import fr.xebia.mowitnow.enumeration.Orientation;


/**
 * Classe de mapping de la position d'une tondeuse
 * 
 * @author Elhadi CHERIFI
 * 
 */
public class Position {
	
	/**
	 * Constructeur de la classe
	 * @param coordinates
	 * @param orientation
	 */
	public Position(Coordinates coordinates, Orientation orientation) {
		this.coordinates = coordinates;
		this.orientation = orientation;
	}

	//coordonnées d'une tondeuse
	private Coordinates coordinates;
	
	//orientation d'une tondeuse
	private Orientation orientation;

	/**
	 * Getter des coordonnées d'une tondeuse
	 * @return the coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * Setter des coordonnées d'une tondeuse
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Getter de l'orientation d'une tondeuse
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * Setter de l'orientation d'une tondeuse
	 * @param orientation the orientation to set
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
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
		Position other = (Position) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		if (orientation != other.orientation)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return coordinates + " " + orientation + "\n";
	}
	
	
	
	

}
