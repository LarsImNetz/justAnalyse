package org.linuxx.moonserver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Integrationstest für den RuntimeWrapper
 *
 * Anlegen eines Temp Files, Aufrufen einer Externen Shell um ein "Hello World" in eine Textdatei zu schreiben
 */
public class ITestRuntimeWrapper {

	private IRuntimeWrapper runtimeWrapperSUT;

	@Before
	public void setUp() {
		runtimeWrapperSUT = new RuntimeWrapper();
	}

	@Test
	public void testExec() throws IOException, InterruptedException {

		File temp = File.createTempFile("temp-file-name", ".tmp");
		Process test = null;
		ArrayList<String> commandList = new ArrayList<>();
		String osType = System.getProperty("os.name");
		if (osType.startsWith("Windows")) {			
			commandList.add("C:\\Windows\\System32\\cmd.exe");
			commandList.add("/C");
			commandList.add("echo Hello World > " + temp.getAbsolutePath());
		}
		else if (osType.startsWith("Linux")) {
			Assert.assertTrue(new File("/bin/bash").exists());
			commandList.add("/bin/bash");
			commandList.add("-c");
			commandList.add("echo Hello World > " + temp.getAbsolutePath());
		}
		else {
			Assert.assertTrue("This system "+ osType +" is not supported yet.", false);
		}
		test = runtimeWrapperSUT.exec(commandList);
		Assert.assertNotNull(test);
		
		test.waitFor();
		int exitValue = test.exitValue();

		Assert.assertEquals(0, exitValue);

		Assert.assertTrue(temp.exists());
		String fileContent = new String(Files.readAllBytes(Paths.get(temp.getAbsolutePath())));

		Assert.assertTrue(fileContent.startsWith("Hello World"));
	}
}
