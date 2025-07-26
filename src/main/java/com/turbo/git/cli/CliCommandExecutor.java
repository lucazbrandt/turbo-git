package com.turbo.git.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.turbo.git.domain.CliCommandResult;
import com.turbo.git.exception.CliCommandException;

public class CliCommandExecutor {

	private String workDirectory;

	public CliCommandExecutor(String workDirectory) {
		this.workDirectory = workDirectory;
	}

	public CliCommandResult execute(String... command) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder(command);
			processBuilder.directory(new File(this.workDirectory));
			processBuilder.redirectErrorStream(true);

			Process process = processBuilder.start();

			List<String> result = new ArrayList<String>();

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line;
				while ((line = reader.readLine()) != null) {
					result.add(line);
				}
			}

			int exitCode = process.waitFor();

			boolean successful = exitCode == 0;

			return new CliCommandResult(successful, String.join("\n", result));
		} catch (Exception e) {
			throw new CliCommandException("Erro ao executar comando:" + String.join(" ", command), e);
		}
	}

}
