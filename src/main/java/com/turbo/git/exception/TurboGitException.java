package com.turbo.git.exception;

public class TurboGitException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public TurboGitException(String errorMessage, Exception error) {
		super(error);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
