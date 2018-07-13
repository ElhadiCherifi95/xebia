package fr.xebia.mowitnow.model;


/**
 * Classe de mapping d'une surface d'une tondeuse
 * 
 * @author Elhadi CHERIFI
 * 
 */
public class Surface {
	
	//coordonnée maximum de la surface sachant que le minimum est (0,0)
	private Coordinates coordinateMax;
	
	/**
	 * Constructeur de la classe Surface
	 * @param coordinateMax
	 */
	public Surface(Coordinates coordinateMax) {
		this.coordinateMax = coordinateMax;
	}

	/**
	 * Getter des coordonnées maximum d'une surface
	 * @return the coordinateMax
	 */
	public Coordinates getCoordinateMax() {
		return coordinateMax;
	}

	/**
	 * Setter des coordonnées maximum d'une surface
	 * @param coordinateMax the coordinateMax to set
	 */
	public void setCoordinateMax(Coordinates coordinateMax) {
		this.coordinateMax = coordinateMax;
	}
	
	
	/**
	 * Methode permettant la vérification qu'un point est dans la surface.
	 * Coordonnées du point en question sont inférieurs aux coordonnées max de la surface
	 * @param les coordonnées à vérifier
	 * @return Booléen indiquant Si le point est dans la surface
	 * 
	 */
	public boolean isValidCoordinatesInSurface(Coordinates coordinates) {
		return this.coordinateMax.getAbciss()>=coordinates.getAbciss() && this.coordinateMax.getOrdinate()>=coordinates.getOrdinate(); 
	}

	
	
	
	

}
