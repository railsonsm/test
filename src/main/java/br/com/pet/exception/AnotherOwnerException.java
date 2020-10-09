package br.com.pet.exception;

public class AnotherOwnerException extends RuntimeException {

	private static final long serialVersionUID = -7827154115502454648L;
	
	public AnotherOwnerException() {
		super("Another Owner");
	}

}
