package fr.xebia.mowitnow.enumeration;

import fr.xebia.mowitnow.model.Coordinates;

/**
 * Enum�ration des orientations d'une tondeuse
 * 
 * @author Elhadi CHERIFI
 */

public enum Orientation {

	//les diff�rentes orientations d'une tondeuse
	N("N"){
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.forwardOrdinate();
			return coordinates;
		}
			
	},S("S"){
		
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.backwardOrdinate();
			return coordinates;
		}
		
	},W("W"){
		
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.backwardAbciss();
			return coordinates;
		}
		
		
	},E("E"){
		
		/**
		 * {@link Orientation#forward(Coordinates)}
		 */
		@Override
		public Coordinates forward(Coordinates coordinates) {
			coordinates.forwardAbciss();
			return coordinates;
		}
		
		
	};
	
	
	//String qui d�finie l'orientation
	private final String orientation;
	//orientation se situation � gauche d'une certaine orientation
    private Orientation left;
    //orientation se situation � droite d'une certaine orientation
    private Orientation right;
    
    //Bloc static permettant la definition des orientation � droite et � gauche de chaque �num�ration
  	static {
          N.left = W;
          N.right = E;
          W.left = S;
          W.right = N;
          E.left = N;
          E.right = S;
          S.left = E;
          S.right = W;
      }	

	/**
	 * Constructeur de l'enumeration des orientations d'une tondeuse
	 * @param orientation
	 */
	private Orientation(String orientation) {
		this.orientation = orientation;
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
	 * M�thode abstraite, � impl�menter pour chaque �lement de l'�num qui permet d'avancer les coordonn�es d'une tondeuse selon son orientation
	 * @param Coordonn�es initiales de la tondeuse
	 * @return Coordonn�es avanc�es selon l'orientation
	 * @since 0.1
	 */
	public abstract Coordinates forward(Coordinates coordinates);
	
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
            return N;
        case "E":
            return E;
        case "S":
            return S;
        case "W":
            return W;
        default:
            return null;
        }
		
	}


	/**
	 * Getter de l'orientation
	 * @return the orientation
	 */
	public String getOrientation() {
		return orientation;
	};	
	
}
