package com.ShoppingCart.Exception;

public class ShoppingCartException extends RuntimeException {

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ShoppingCartException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
}
