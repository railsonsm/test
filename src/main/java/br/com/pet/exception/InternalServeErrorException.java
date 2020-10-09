package br.com.pet.exception;

public class InternalServeErrorException extends RuntimeException {

	private static final long serialVersionUID = -7827154115502454648L;
	
	public InternalServeErrorException(String message) {
		super(message);
	}

}
