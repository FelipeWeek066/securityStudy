package com.week.security.services.exceptions;

public class ContentNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ContentNotFound(String msg) {
		super(msg);
	}
}
