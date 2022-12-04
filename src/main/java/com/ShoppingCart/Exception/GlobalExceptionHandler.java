package com.ShoppingCart.Exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	private static final String ERROR_MSG = "Error while fetching Item details";

	public GlobalExceptionHandler() {
		
	}
	
@ExceptionHandler
public ResponseEntity<ErrorResponse> handleExc(ShoppingCartException exception)
{
	List<String> errorMsg = new ArrayList<>();
	errorMsg.add(exception.getErrorMessage());
	ErrorResponse error = new ErrorResponse(ERROR_MSG,errorMsg);
	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
}
