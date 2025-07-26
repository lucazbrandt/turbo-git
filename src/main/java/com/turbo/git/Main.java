package com.turbo.git;

import com.turbo.git.chain.factory.GitCommandChainFactory;
import com.turbo.git.domain.CommitMessage;
import com.turbo.git.handler.TurboGitExceptionHandler;

public class Main {

	public static void main(String... args) {
		String repository = args[0];
		String commitMessage = args[1];

		System.out.println("Executando no repositorio: " + repository);

		try {
			var chain = GitCommandChainFactory.createChain(repository);
			chain.execute(new CommitMessage(commitMessage));
		} catch (Exception exception) {
			TurboGitExceptionHandler.handleError(exception);
		}
	}
}
