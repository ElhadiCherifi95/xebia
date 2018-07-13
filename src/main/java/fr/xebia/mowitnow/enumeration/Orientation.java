package fr.xebia.mowitnow.enumeration;

import fr.xebia.mowitnow.model.Coordinates;

/**
 * Enum�ration des orientations d'une tondeuse
 * 
 * @author Elhadi CHERIFI
 */

public enum Orientation {

	//les diff�rentes orientations d'une tondeuse
	NORTH("N"){
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.forwardOrdinate();
			return coordinates;
		}
			
	},SOUTH("S"){
		
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.backwardOrdinate();
			return coordinates;
		}
		
	},WEST("W"){
		
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.backwardAbciss();
			return coordinates;
		}
		
		
	},EAST("E"){
		
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.forwardAbciss();
			return coordinates;
		}
		
		
	};
	
	private final String orientation;
	

	/**
	 * Constructeur de l'enumeration des orientations d'une tondeuse
	 * @param orientation
	 */
	private Orientation(String orientation) {
		this.orientation = orientation;
	}


	/**
	 * M�thode qui r�cup�re l'orientation � partir d'un string
	 * @return l'orientation
	 */
	public static Orientation getOrientation(String dir) {
		if (dir == null) {
            return null;
        }

        switch (dir) {
        case "N":
            return NORTH;
        case "E":
            return EAST;
        case "S":
            return SOUTH;
        case "W":
            return WEST;
        default:
            return null;
        }
		
	}
	
	/**
	 * M�thode abstraite, � impl�menter pour chaque �lement de l'�num qui permet d'avancer les coordonn�es d'une tondeuse selon son orientation
	 * @param Coordonn�es initiales de la tondeuse
	 * @return Coordonn�es avanc�es selon l'orientation
	 * @since 0.1
	 */
	public abstract Coordinates forward(Coordinates coordinates);
	
	//orientation se situation � gauche d'une certaine orientation
    private Orientation left;
    //orientation se situation � droite d'une certaine orientation
    private Orientation right;
    
  //Bloc static permettant la definition des orientation � droite et � gauche de chaque �num�ration
  	static {
          NORTH.left = WEST;
          NORTH.right = EAST;
          WEST.left = SOUTH;
          WEST.right = NORTH;
          EAST.left = NORTH;
          EAST.right = SOUTH;
          SOUTH.left = EAST;
          SOUTH.right = WEST;
      }
	
	
	/**
	 * M�thode abstraite, � impl�menter pour chaque �lement de l'�num qui permet de changer l'orientation d'une tondeuse selon un sens horaire
	 * @param Orientation initiales de la tondeuse
	 * @return Orientation suivante au sens horaire selon l'orientation
	 */
	public Orientation next() {return this.right;};
	
	/**
	 * M�thode abstraite, � impl�menter pour chaque �lement de l'�num qui permet de changer l'orientation d'une tondeuse selon un sens anti-horaire
	 * @param Orientation initiales de la tondeuse
	 * @return Orientation suivante au sens anti-horaire selon l'orientation
	 */
	public Orientation back() {return this.left;}


	/**
	 * @return the orientation
	 */
	public String getOrientation() {
		return orientation;
	};
	
	
	
	
}
