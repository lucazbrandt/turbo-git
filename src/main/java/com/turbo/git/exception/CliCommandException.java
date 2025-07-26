package com.turbo.git.exception;

public class CliCommandException extends TurboGitException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CliCommandException(String errorMessage, Exception error) {
		super(errorMessage, error);
	}
}
