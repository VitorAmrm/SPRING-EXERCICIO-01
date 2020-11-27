package com.ayty.fintech.exceptions;

public class AlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	
	
	public AlreadyExistException(String msg) {
		this.msg = msg;
	}



	@Override
	public String getMessage() {
		return this.msg;
	}

	
}
