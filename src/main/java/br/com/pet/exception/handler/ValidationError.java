package br.com.pet.exception.handler;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ValidationError extends ApiError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public void addError(String fielName, String messagem) {
		errors.add(new FieldMessage(fielName, messagem));
	}

}
