package com.turbo.git.chain.common;

import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.CliCommandResult;
import com.turbo.git.domain.GitData;

public abstract class GitCommandStep<I extends GitData, O extends GitData> {

	private GitCommandStep<O, ?> next;
	private CliCommandExecutor cliCommandExecutor;

	public GitCommandStep(GitCommandStep<O, ?> next, CliCommandExecutor cliCommandExecutor) {
		this.next = next;
		this.cliCommandExecutor = cliCommandExecutor;
	}
	
	public void execute(I inputData) {
		var outputData = this.executeStep(inputData);
		
		if(next != null) {
			next.execute(outputData);
		}
	}
	
	protected CliCommandResult executeCommand(String... command) {
		return cliCommandExecutor.execute(command);
	}
	
	protected abstract O executeStep(I data);
}
