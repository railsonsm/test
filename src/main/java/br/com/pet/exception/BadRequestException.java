package br.com.pet.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -7827154115502454648L;
	
	public BadRequestException(String message) {
		super(message);
	}

}
