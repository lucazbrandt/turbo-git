package com.turbo.git.chain.step;

import com.turbo.git.chain.common.GitCommandStep;
import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.Branch;

public class GoodbyeStep extends GitCommandStep<Branch, Branch> {

	public GoodbyeStep(GitCommandStep<Branch, ?> next, CliCommandExecutor cliCommandExecutor) {
		super(next, cliCommandExecutor);
	}

	@Override
	protected Branch executeStep(Branch data) {
		System.out.println("C'est fini!!!");
		return null;
	}

}
