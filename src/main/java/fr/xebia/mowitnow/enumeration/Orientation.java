package fr.xebia.mowitnow.enumeration;

import fr.xebia.mowitnow.model.Coordinates;

/**
 * Enumération des orientations d'une tondeuse
 * 
 * @author Elhadi CHERIFI
 */

public enum Orientation {

	//les différentes orientations d'une tondeuse
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
	 * Méthode qui récupère l'orientation à partir d'un string
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
	 * Méthode abstraite, à implémenter pour chaque élement de l'énum qui permet d'avancer les coordonnées d'une tondeuse selon son orientation
	 * @param Coordonnées initiales de la tondeuse
	 * @return Coordonnées avancées selon l'orientation
	 * @since 0.1
	 */
	public abstract Coordinates forward(Coordinates coordinates);
	
	//orientation se situation à gauche d'une certaine orientation
    private Orientation left;
    //orientation se situation à droite d'une certaine orientation
    private Orientation right;
    
  //Bloc static permettant la definition des orientation à droite et à gauche de chaque énumération
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
	 * Méthode abstraite, à implémenter pour chaque élement de l'énum qui permet de changer l'orientation d'une tondeuse selon un sens horaire
	 * @param Orientation initiales de la tondeuse
	 * @return Orientation suivante au sens horaire selon l'orientation
	 */
	public Orientation next() {return this.right;};
	
	/**
	 * Méthode abstraite, à implémenter pour chaque élement de l'énum qui permet de changer l'orientation d'une tondeuse selon un sens anti-horaire
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
