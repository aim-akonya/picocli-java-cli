/**
 * 
 */
package com.aim.app.checksum;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * @author aim
 *
 */

@Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0", description = "Prints the checksum (MD5 by default) of a file to STDOUT.")
public class Checksum implements Callable<Integer> {

	@Parameters(index = "0", description = "The file whose checksum tocalculate")
	private File file;

	@Option(names = { "-a", "--algorithm" }, description = "MD5, SHA-1, SHA-256, ...")
	private String algorithm = "MD5";

	@Override
	public Integer call() throws Exception {
		byte [] fileContents = Files.readAllBytes(file.toPath());
		byte [] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
		System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
		return 0;
	}
}
