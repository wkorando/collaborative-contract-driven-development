package com.developer.ibm.football.footballplaytrackerservice;

public class ClientException extends RuntimeException {

	private static final long serialVersionUID = -7599972394451913652L;
	private String[] errorMessages;

	public ClientException(String... errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public String[] getErrorMessages() {
		return errorMessages;
	}
}
