package fr.xebia.mowitnow.model;
/**
 * Classe de mapping des coordonn�es d'une tondeuse
 * 
 * @author Elhadi CHERIFI
 */
public class Coordinates {

	//abcisse d'une tondeuse sur la surface
	private int abciss;

	//ordonn�e d'une tondeuse sur la surface
	private int ordinate;

	/**
	 * Constructeur de la classe Coordinates
	 * @param abciss
	 * @param ordinate
	 */
	public Coordinates(int abciss, int ordinate) throws IllegalArgumentException  {
		if(abciss < 0 || ordinate < 0) {
			throw new IllegalArgumentException("Les coordonn�es d'une position doivent �tre positifs");
			
		}
		else {
			this.abciss = abciss;
			this.ordinate = ordinate;
		}
		
	}



	/**
	 * @return the abciss
	 */
	public int getAbciss() {
		return abciss;
	}

	/**
	 * @param abciss the abciss to set
	 */
	public void setAbciss(int abciss) {
		if(abciss>0)
			this.abciss = abciss;
	}

	/**
	 * @return the ordinate
	 */
	public int getOrdinate() {
		return ordinate;
	}

	/**
	 * setter de l'ordonn�e
	 * @param ordinate the ordinate to set
	 */
	public void setOrdinate(int ordinate) {
		if(ordinate>0)
			this.ordinate = ordinate;
	}

	/**
	 * M�thode qui permet d'avancer l'abcisse d'un pas de 1 d'une tondeuse sur le plan
	 * @return abcisse + 1
	 * @since 0.1
	 */	
	public void forwardAbciss() {
		abciss++;
	};

	/**
	 * M�thode qui permet d'avancer d'un pas de 1 l'odonn�e d'une tondeuse sur le plan
	 * @return ordonn�e + 1
	 * @since 0.1
	 */	
	public void forwardOrdinate() {
		ordinate++;
	};

	/**
	 * M�thode qui permet de reculer d'un pas de 1 l'abcisse d'une tondeuse sur le plan
	 * @return abcisse - 1
	 * @since 0.1
	 */	
	public void backwardAbciss() {
		if(abciss>0)
			abciss--;
		
	};

	/**
	 * M�thode qui permet de reculer d'un pas de 1 l'odonn�e d'une tondeuse sur le plan
	 * @return ordonn�e - 1
	 * @since 0.1
	 */	
	public void backwardOrdinate() {
		if(ordinate>0)
			ordinate--;
		
	};




	


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abciss;
		result = prime * result + ordinate;
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
		Coordinates other = (Coordinates) obj;
		if (abciss != other.abciss)
			return false;
		if (ordinate != other.ordinate)
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return abciss + " " + ordinate;
	}




}
