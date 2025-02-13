package com.palmyralabs.examples.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.palmyralabs.examples.model.ErrorResponse;
import com.palmyralabs.palmyra.base.exception.EndPointForbiddenException;
import com.palmyralabs.palmyra.base.exception.ResourceAlreadyExistsException;
import com.palmyralabs.palmyra.base.exception.ResourceNotFoundException;
import com.zitlab.palmyra.common.exception.PalmyraException;
import com.zitlab.palmyra.store.base.exception.TupleTypeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException e) {
		return notFound(getErrorResponse(e));
	}
	
	@ExceptionHandler(TupleTypeNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundException(TupleTypeNotFoundException e) {
		ErrorResponse response = new ErrorResponse("404",  "Table not found - " + e.getType());
		return notFound(response);
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> resourceAlreadyExists(ResourceAlreadyExistsException e) {
		return alreadyExists(getErrorResponse(e));
	}

	@ExceptionHandler(EndPointForbiddenException.class)
	public ResponseEntity<ErrorResponse> unauthorizedException(EndPointForbiddenException e) {
		return forbidden(getErrorResponse(e));
	}

	protected final ResponseEntity<ErrorResponse> badRequest(ErrorResponse response) {
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	private ErrorResponse getErrorResponse(PalmyraException e) {
		return new ErrorResponse(e.getErrorCode(), e.getMessage());
	}
	
	protected final ResponseEntity<ErrorResponse> notFound(ErrorResponse response) {
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	protected final ResponseEntity<ErrorResponse> alreadyExists(ErrorResponse response) {
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	protected final ResponseEntity<ErrorResponse> forbidden(ErrorResponse response) {
		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}
}
