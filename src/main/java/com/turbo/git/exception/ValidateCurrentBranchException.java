package com.turbo.git.exception;

public class ValidateCurrentBranchException extends TurboGitException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidateCurrentBranchException(String errorMessage) {
		super(errorMessage, null);
	}
}
