package fr.xebia.mowitnow.model;


/**
 * Classe de mapping d'une surface d'une tondeuse compos� d'une {@link fr.xebia.mowitnow.model.Coordinates} qui correspond au coin sup�rieur droit.
 * 
 * @author Elhadi CHERIFI
 * 
 */
public class Surface extends Coordinates {
	
		
	public Surface(int abciss, int ordinate) {
		super(abciss, ordinate);
	}

	/**
	 * Methode permettant la v�rification qu'un point est dans la surface.
	 * Coordonn�es du point en question sont inf�rieurs aux coordonn�es max de la surface
	 * @param les coordonn�es � v�rifier
	 * @return Bool�en indiquant Si le point est dans la surface
	 * 
	 */
	public boolean isValidCoordinatesInSurface(Coordinates coordinates) {
		return this.getAbciss()>=coordinates.getAbciss() && this.getOrdinate()>=coordinates.getOrdinate(); 
	}	
	

}
