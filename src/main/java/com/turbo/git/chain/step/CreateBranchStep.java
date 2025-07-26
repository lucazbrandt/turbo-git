package com.turbo.git.chain.step;

import com.turbo.git.chain.common.GitCommandStep;
import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.Branch;
import com.turbo.git.exception.CreateBranchStepException;

public class CreateBranchStep extends GitCommandStep<Branch, Branch> {

	public CreateBranchStep(GitCommandStep<Branch, ?> next, CliCommandExecutor cliCommandExecutor) {
		super(next, cliCommandExecutor);
	}

	@Override
	protected Branch executeStep(Branch branch) {
		System.out.println("Criando a branch: " + branch.getName());

		var result = executeCommand("git", "switch", "-c", branch.getName());

		if (!result.isSuccessful()) {
			throw new CreateBranchStepException("Erro ao criar branch. Erro: \n" + result.getCommandResult());
		}

		return branch;
	}

}
