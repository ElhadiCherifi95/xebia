package fr.xebia.mowitnow.model;


/**
 * Classe de mapping d'une surface d'une tondeuse
 * 
 * @author Elhadi CHERIFI
 * 
 */
public class Surface {
	
	//coordonn�e maximum de la surface sachant que le minimum est (0,0)
	private Coordinates coordinateMax;
	
	/**
	 * Constructeur de la classe Surface
	 * @param coordinateMax
	 */
	public Surface(Coordinates coordinateMax) {
		this.coordinateMax = coordinateMax;
	}

	/**
	 * Getter des coordonn�es maximum d'une surface
	 * @return the coordinateMax
	 */
	public Coordinates getCoordinateMax() {
		return coordinateMax;
	}

	/**
	 * Setter des coordonn�es maximum d'une surface
	 * @param coordinateMax the coordinateMax to set
	 */
	public void setCoordinateMax(Coordinates coordinateMax) {
		this.coordinateMax = coordinateMax;
	}
	
	
	/**
	 * Methode permettant la v�rification qu'un point est dans la surface.
	 * Coordonn�es du point en question sont inf�rieurs aux coordonn�es max de la surface
	 * @param les coordonn�es � v�rifier
	 * @return Bool�en indiquant Si le point est dans la surface
	 * 
	 */
	public boolean isValidCoordinatesInSurface(Coordinates coordinates) {
		return this.coordinateMax.getAbciss()>=coordinates.getAbciss() && this.coordinateMax.getOrdinate()>=coordinates.getOrdinate(); 
	}

	
	
	
	

}
