package com.turbo.git.chain.factory;

import com.turbo.git.chain.common.GitCommandStep;
import com.turbo.git.chain.step.BranchCommitStep;
import com.turbo.git.chain.step.BranchExtractorStep;
import com.turbo.git.chain.step.BranchPushStep;
import com.turbo.git.chain.step.CreateBranchStep;
import com.turbo.git.chain.step.GoodbyeStep;
import com.turbo.git.chain.step.ValidateCurrentBranchStep;
import com.turbo.git.cli.CliCommandExecutor;
import com.turbo.git.domain.CommitMessage;

public class GitCommandChainFactory {

	public static GitCommandStep<CommitMessage, ?> createChain(String repoPath) {
		var cliCommandExecutor = new CliCommandExecutor(repoPath);
		
		var goodbyeStep = new GoodbyeStep(null, cliCommandExecutor);
		var branchPushStep = new BranchPushStep(goodbyeStep, cliCommandExecutor);
		var branchCommitStep = new BranchCommitStep(branchPushStep, cliCommandExecutor);
		var createBranchStep = new CreateBranchStep(branchCommitStep, cliCommandExecutor);
		var branchExtractorStep = new BranchExtractorStep(createBranchStep, cliCommandExecutor);
		var validateCurrentBranchStep = new ValidateCurrentBranchStep(branchExtractorStep, cliCommandExecutor);

		return validateCurrentBranchStep;
	}
}
