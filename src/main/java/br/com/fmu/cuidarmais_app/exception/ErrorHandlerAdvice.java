package br.com.fmu.cuidarmais_app.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ErrorHandlerAdvice {

	@ExceptionHandler( MethodArgumentNotValidException.class )
	public ResponseEntity<ErrorResponse> handleException( MethodArgumentNotValidException e ) {
		List<String> errors = e.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.toList());
		log.warn("MethodArgumentNotValidException: " + errors.toString());
		
		ErrorResponse response = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(),
				errors);
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleGastoNotFoundException(RoleNotFoundException e) {
		log.warn("RoleNotFoundException: " + e.getMessage());
		
		ErrorResponse response = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				List.of(e.getMessage()));
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND.value())
				.body(response);
	}
	
	@ExceptionHandler(RoleNameDuplicatedException.class)
	public ResponseEntity<ErrorResponse> handleGastoNotFoundException(RoleNameDuplicatedException e) {
		log.warn("RoleNameDuplicatedException: " + e.getMessage());
		
		ErrorResponse response = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(),
				List.of(e.getMessage()));
		
		return ResponseEntity
				.status(HttpStatus.CONFLICT.value())
				.body(response);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleGastoNotFoundException(UserNotFoundException e) {
		log.warn("UserNotFoundException: " + e.getMessage());
		
		ErrorResponse response = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(),
				List.of(e.getMessage()));
		
		return ResponseEntity
				.status(HttpStatus.CONFLICT.value())
				.body(response);
	}
}
