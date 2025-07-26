package com.turbo.git.domain;

public class CommitMessage implements GitData {

	private String message;

	public CommitMessage(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
