package com.ibm.developer.movie;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 8772689966777045661L;
	private String[] errorMessages;

	public ServiceException(String... errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public String[] getErrorMessages() {
		return errorMessages;
	}
}
