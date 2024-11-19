package br.com.fmu.cuidarmais_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompanyVaccineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CompanyVaccineNotFoundException(String message) {
		super(message);
	}
	
}
