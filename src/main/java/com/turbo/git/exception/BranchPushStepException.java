package com.turbo.git.exception;

public class BranchPushStepException extends TurboGitException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BranchPushStepException(String errorMessage) {
		super(errorMessage, null);
	}

}
