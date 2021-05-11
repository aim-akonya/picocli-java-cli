package com.aim.app;

import picocli.CommandLine;
import com.aim.app.checksum.Checksum;

public class Application {

	public static void main(String[] args) {
		int exitCode = new CommandLine(new Checksum()).execute(args);
		System.exit(exitCode);
	}
}
