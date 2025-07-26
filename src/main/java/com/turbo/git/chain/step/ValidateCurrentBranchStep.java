package com.turbo.git.chain.step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.turbo.git.chain.common.GitCommandStep;
import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.CommitMessage;
import com.turbo.git.exception.ValidateCurrentBranchException;

public class ValidateCurrentBranchStep extends GitCommandStep<CommitMessage, CommitMessage> {

	private static String REGEX = "^(develop|release|main)";

	public ValidateCurrentBranchStep(GitCommandStep<CommitMessage, ?> next,
			CliCommandExecutor cliCommandExecutor) {
		super(next, cliCommandExecutor);
	}

	@Override
	protected CommitMessage executeStep(CommitMessage commitMessage) {
		System.out.println("Validando branch atual");
		var result = executeCommand("git", "branch", "--show-current");

		if (!result.isSuccessful()) {
			throw new ValidateCurrentBranchException("Erro ao validar branch atual: " + result.getCommandResult());
		}

		var pattern = Pattern.compile(REGEX);

		Matcher matcher = pattern.matcher(result.getCommandResult());

		if (!matcher.find()) {
			throw new ValidateCurrentBranchException("A branch atual deve ser develop, release ou main");
		}

		return commitMessage;
	}

}
