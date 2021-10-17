package com.ryde.sg.exception;

public class CreateUserException extends Exception{
	
	public CreateUserException(String message, Throwable  err) {
		super(message, err);
	}

}
