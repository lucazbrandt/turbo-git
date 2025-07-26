package com.turbo.git.chain.step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.turbo.git.chain.common.GitCommandStep;
import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.Branch;
import com.turbo.git.domain.CommitMessage;
import com.turbo.git.exception.BranchExtractorStepException;

public class BranchExtractorStep extends GitCommandStep<CommitMessage, Branch> {

	private static String REGEX = "^(feat|fix|docs|style|perf|test)\\((.*?)\\):";

	public BranchExtractorStep(GitCommandStep<Branch, ?> next, CliCommandExecutor cliCommandExecutor) {
		super(next, cliCommandExecutor);
	}

	@Override
	protected Branch executeStep(CommitMessage data) {
		System.out.println("Extraindo branch");
		var commitMessage = (CommitMessage) data;
		var pattern = Pattern.compile(REGEX);

		Matcher matcher = pattern.matcher(commitMessage.getMessage());

		if (!matcher.find()) {
			throw new BranchExtractorStepException(
					"Mensagem de commit em formato invalido. Mensagem: " + data.getMessage());
		}

		var commitType = matcher.group(1);
		var task = matcher.group(2);

		return new Branch(data.getMessage(), commitType + "/" + task);
	}

}
