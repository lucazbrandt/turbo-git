package com.turbo.git.chain.step;

import com.turbo.git.chain.common.GitCommandStep;
import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.Branch;
import com.turbo.git.exception.BranchPushStepException;

public class BranchPushStep extends GitCommandStep<Branch, Branch> {

	public BranchPushStep(GitCommandStep<Branch, ?> next, CliCommandExecutor cliCommandExecutor) {
		super(next, cliCommandExecutor);
	}

	@Override
	protected Branch executeStep(Branch branch) {
		System.out.println("Enviando as alterações para branch remota: " + branch.getName());

		var result = executeCommand("git", "push", "origin", branch.getName());

		if (!result.isSuccessful()) {
			throw new BranchPushStepException("Erro ao enviar branch" + branch.getName()
					+ " para repositorio remoto. Erro: " + result.getCommandResult());
		}

		return branch;
	}

}
