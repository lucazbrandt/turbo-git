package com.turbo.git.chain.step;

import com.turbo.git.chain.common.GitCommandStep;
import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.Branch;
import com.turbo.git.exception.BranchCommitStepException;

public class BranchCommitStep extends GitCommandStep<Branch, Branch> {

	public BranchCommitStep(GitCommandStep<Branch, ?> next, CliCommandExecutor cliCommandExecutor) {
		super(next, cliCommandExecutor);
	}

	@Override
	protected Branch executeStep(Branch branch) {
		System.out.println("Comitando alterações na branch:" + branch.getName());

		var addResult = executeCommand("git", "add", ".");

		if (!addResult.isSuccessful()) {
			throw new BranchCommitStepException("Erro ao adicionar artefatos na branch:" + branch.getName());
		}

		var commitResult = executeCommand("git", "commit", "-m", branch.getMessage());

		if (!commitResult.isSuccessful()) {
			throw new BranchCommitStepException("Erro ao commitar artefatos na branch:" + branch.getName());
		}

		return branch;
	}

}
