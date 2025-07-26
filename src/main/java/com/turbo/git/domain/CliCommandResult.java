package com.turbo.git.domain;

public class CliCommandResult {

	private boolean successful;
	private String commandResult;

	public CliCommandResult(boolean successful, String commandResult) {
		super();
		this.successful = successful;
		this.commandResult = commandResult;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public String getCommandResult() {
		return commandResult;
	}

}
