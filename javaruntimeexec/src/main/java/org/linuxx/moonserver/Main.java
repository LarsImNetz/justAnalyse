package org.linuxx.moonserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
//		String[] cmd = { "/bin/bash", "-c", "echo Hello World >/tmp/test.txt" };
//		execCommand(cmd);

		File tempFile = File.createTempFile("temp", ".txt");
//		String cmdSingle =  "/bin/bash -c echo Hello World >" + tempFile.getAbsolutePath();
//		execSingleCommand(cmdSingle);

		ArrayList<String> command = new ArrayList<>();
		command.add("/bin/bash");
		command.add("-c");
		command.add("echo Hello World >" + tempFile.getAbsolutePath());
		execSingleCommand(command);
	}

	static void ownRuntime() throws Exception {
		RuntimeWrapper runtimeWrapperSUT = new RuntimeWrapper();

		System.out.println("#####################################################################################");
		File temp = File.createTempFile("temp-file-name", ".tmp");
		Process test = null;
		String command = null;
		System.out.println("os.name: " + System.getProperty("os.name"));
		System.out.println("Tempfile: " + temp.getAbsolutePath());
		if (System.getProperty("os.name").startsWith("Windows")) {
			command = "C:\\Windows\\System32\\cmd.exe /C echo Hello World > " + temp.getAbsolutePath();
			System.out.println("#" + command);
		}
		if (System.getProperty("os.name").startsWith("Linux")) {
			System.out.println("/bin/bash exists: " + new File("/bin/bash").exists());
			command = "/bin/bash -c 'echo Hello World' > " + temp.getAbsolutePath();
			System.out.println("#" + command);
		}
		System.out.println("#####################################################################################");
		test = runtimeWrapperSUT.exec(command);

		test.waitFor();
		int exitValue = test.exitValue();

		System.out.println("Program exit with: " + exitValue);
		Thread.sleep(300);

		String fileContent = new String(Files.readAllBytes(Paths.get(temp.getAbsolutePath())));
		System.out.println("FileContent: " + fileContent);

	}

//	static void execCommand(String[] commandArr) {
//		String line;
//		try {
//			Process p = Runtime.getRuntime().exec(commandArr);
//			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			while ((line = stdoutReader.readLine()) != null) {
//				// process procs standard output here
//				System.out.println(" .. stdout: " + line);
//			}
//			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//			while ((line = stderrReader.readLine()) != null) {
//				// process procs standard error here
//				System.err.println(" .. stderr: " + line);
//			}
//			int retValue = p.waitFor();
//			System.out.println(" .. exit code:" + Integer.toString(retValue));
//		} catch (Exception e) {
//			System.err.println(e.toString());
//		}
//	}

	static void execSingleCommand(List<String> commandList) {
		String line;
		try {
			Process p = new ProcessBuilder(commandList).start();
			//Process p = Runtime.getRuntime().exec(command);
			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = stdoutReader.readLine()) != null) {
				// process procs standard output here
				System.out.println(" .. stdout: " + line);
			}
			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = stderrReader.readLine()) != null) {
				// process procs standard error here
				System.err.println(" .. stderr: " + line);
			}
			int retValue = p.waitFor();
			System.out.println(" .. exit code:" + Integer.toString(retValue));

			int retValue2 = p.exitValue();
			System.out.println(" .. exit2 code:" + Integer.toString(retValue2));
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

}
