package br.com.pet.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.pet.exception.AnotherOwnerException;
import br.com.pet.exception.NoContentException;
import br.com.pet.exception.ObjectNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	private static final Logger log = LoggerFactory.getLogger(ResourceExceptionHandler.class);

	@ExceptionHandler(BindException.class)
	public ResponseEntity<ApiError> validation(BindException e, HttpServletRequest req) {
		log.error("Causa: {} : {}", e.toString(), e.getMessage());

		ValidationError validationError = new ValidationError(System.currentTimeMillis(),
				HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", "Erro de validação", req.getRequestURI());
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			validationError.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validationError);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> validation(MethodArgumentNotValidException e, HttpServletRequest req) {	
		log.error("Causa: {} : {}", e.toString(), e.getMessage());
		
		ValidationError validationError = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Error", "Erro de valida��o", req.getRequestURI());
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			validationError.addError(f.getField(),f.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validationError);
	}

	

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiError httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest req) {
		log.error("Causa: {} : {}", e.toString(), "JSON parse error");

		ApiError error = new ApiError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage(), e.getMessage(), req.getRequestURI());
		return error;
	}
	
	
	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApiError objectNotFountException(ObjectNotFoundException e, HttpServletRequest req) {
		log.error("Causa: {} : {}", e.toString(), e.getMessage());

		ApiError error = new ApiError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage(), message("object.not.found"), req.getRequestURI());
		return error;
	}
	
	@ExceptionHandler(NoContentException.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ApiError NoContentException(NoContentException e, HttpServletRequest req) {
		log.error("Causa: {} : {}", e.toString(), e.getMessage());
		return null;
	}
	
	@ExceptionHandler(AnotherOwnerException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApiError anotherOwnerException(AnotherOwnerException e, HttpServletRequest req) {
		log.error("Causa: {} : {}", e.toString(), e.getMessage());

		ApiError error = new ApiError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage(), message("another.owner"), req.getRequestURI());
		return error;
	}
	
	
	

	private String message(final String code, final Object... params) {
		return messageSource.getMessage(code, params, LocaleContextHolder.getLocale());
	}
}
