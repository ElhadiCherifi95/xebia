package fr.xebia.mowitnow.model;


/**
 * Classe de mapping d'une surface d'une tondeuse composé d'une {@link fr.xebia.mowitnow.model.Coordinates} qui correspond au coin supérieur droit.
 * 
 * @author Elhadi CHERIFI
 * 
 */
public class Surface extends Coordinates {
	
		
	public Surface(int abciss, int ordinate) {
		super(abciss, ordinate);
	}

	/**
	 * Methode permettant la vérification qu'un point est dans la surface.
	 * Coordonnées du point en question sont inférieurs aux coordonnées max de la surface
	 * @param les coordonnées à vérifier
	 * @return Booléen indiquant Si le point est dans la surface
	 * 
	 */
	public boolean isValidCoordinatesInSurface(Coordinates coordinates) {
		return this.getAbciss()>=coordinates.getAbciss() && this.getOrdinate()>=coordinates.getOrdinate(); 
	}	
	

}
