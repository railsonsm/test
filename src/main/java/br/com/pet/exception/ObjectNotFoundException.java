package br.com.pet.exception;

import lombok.Getter;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7827154115502454648L;
	
	@Getter
	private String erroMsg;
	
	public ObjectNotFoundException() {
		super("Not found");
	}

}
