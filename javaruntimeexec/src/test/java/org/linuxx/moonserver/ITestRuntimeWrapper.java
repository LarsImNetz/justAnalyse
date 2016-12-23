package org.linuxx.moonserver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
			Assert.assertTrue(new File("/bin/bash").exists());
			command = "/bin/bash -c \"echo Hello World > " + temp.getAbsolutePath() + "\"";
			System.out.println("#" + command);
		}
		System.out.println("#####################################################################################");
		test = runtimeWrapperSUT.exec(command);
		Assert.assertNotNull(test);
		
		test.waitFor();
		int exitValue = test.exitValue();

		Assert.assertEquals(0, exitValue);
		Thread.sleep(300);

		Assert.assertTrue(temp.exists());
		String fileContent = new String(Files.readAllBytes(Paths.get(temp.getAbsolutePath())));

		Assert.assertTrue(fileContent.startsWith("Hello World"));
	}
}
