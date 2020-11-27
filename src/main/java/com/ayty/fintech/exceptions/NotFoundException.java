package com.ayty.fintech.exceptions;

public class NotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public NotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
	
	
	
	
}
