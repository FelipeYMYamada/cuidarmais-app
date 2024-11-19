package br.com.fmu.cuidarmais_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class VaccineDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VaccineDuplicatedException(String message) {
		super(message);
	}
}
