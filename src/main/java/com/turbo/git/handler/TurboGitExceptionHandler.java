package com.turbo.git.handler;

import com.turbo.git.exception.TurboGitException;

public class TurboGitExceptionHandler {
	public static void handleError(Exception error) {
		if (error instanceof TurboGitException) {
			var gitTurboError = (TurboGitException) error;
			System.err.println("Exception class: " + gitTurboError.getClass().getSimpleName());
			System.err.println("Erro: " + gitTurboError.getErrorMessage());
			if (error.getCause() != null) {
				System.err.println("Error message: " + gitTurboError.getMessage());
			}

			return;
		}

		System.err.println("Erro não mapeado!!!");
		error.printStackTrace();
	}
}
