package fr.xebia.mowitnow.enumeration;

import fr.xebia.mowitnow.model.Position;

/**
 * Enumération des contrôles appliquées à une tondeuse
 * 
 * @author Elhadi CHERIFI
 */

public enum Control {
	
	//les différents controles appliquées à une tondeuse implémentant la méthode abstraite
	RIGHT("D"){
		@Override
		public Position apply(Position position) { return new Position(position.getCoordinates(), position.getOrientation().next());}
	},LEFT("G"){
		@Override
		public Position apply(Position position) {return new Position(position.getCoordinates(), position.getOrientation().back());}
	},FORWARD("A"){
		@Override
		public Position apply(Position position) {return new Position(position.getOrientation().forward(position.getCoordinates()), position.getOrientation());}
	};
	
	private final String control;
	
	

	/**
	 * Constructeur de l'enumeration des contrôles appliquées à une tondeuse
	 * @param control
	 */
	private Control(String control) {
		this.control = control;
	}



	/**
	 * Getter de l'enumeration controle à partir d'un char
	 * @return the control
	 */
	public String getControl() {
		return control;
	}
	
	
	/**
	 * méthode abstraite, à implémenter pour chaque élement de l'énum qui permet d'appliquer un controle sur la position d'une tondeuse
	 * @param la position initiale de la tondeuse
	 * @return la position actualisée de la tondeuse après aplication de la commande
	 */
	public abstract Position apply(Position position);
	
	/**
	 * Méthode qui récupère le controle à partir d'un string
	 * @return l'orientation
	 */
	public static Control getOrientation(String dir) {
		if (dir == null) {
            return null;
        }

        switch (dir) {
        case "D":
            return RIGHT;
        case "G":
            return LEFT;
        case "A":
            return FORWARD;
        default:
            return null;
        }
		
	}
	
}
