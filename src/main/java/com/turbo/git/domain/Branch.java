package com.turbo.git.domain;

public class Branch extends CommitMessage {

	private String name;

	public Branch(String message, String name) {
		super(message);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
