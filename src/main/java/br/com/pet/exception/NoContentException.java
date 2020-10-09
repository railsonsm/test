package br.com.pet.exception;

public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = -7827154115502454648L;
	
	public NoContentException() {
		super("No content");
	}

}
