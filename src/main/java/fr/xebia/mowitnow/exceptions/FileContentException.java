package fr.xebia.mowitnow.exceptions;


/**
 *Classe qui implémente les exceptions liées aux fichiers lus en entrée
 * 
 * 
 * @author Elhadi CHERIFI* 
 */
public class FileContentException extends Exception {

	private static final long serialVersionUID = 1L;	
	private String fileIssue;
	

	/**
	 * Constructeur de l'exception 
	 * @param fileIssue
	 */
	public FileContentException(String fileIssue) {
		super();
		this.fileIssue = fileIssue;
	}

	/**
	 * @return the fileIssue
	 */
	public String getFileIssue() {
		return fileIssue;
	}

	/**
	 * @param fileIssue the fileIssue to set
	 */
	public void setFileIssue(String fileIssue) {
		this.fileIssue = fileIssue;
	}

}
