package fr.xebia.mowitnow;

import fr.xebia.mowitnow.exceptions.FileContentException;
import fr.xebia.mowitnow.tools.Reader;

public class App {
	
	public static void main(String[] args) throws FileContentException {
		
		Reader reader;
		
		if (args.length > 0) {
			reader = new Reader(args[0]);
			
			reader.read().forEach(mower -> System.out.println(mower.apply()));

		} else {
			throw new FileContentException("Le chemin du fichier en entrée n'a pas été spécifié");
		}

	}

}
