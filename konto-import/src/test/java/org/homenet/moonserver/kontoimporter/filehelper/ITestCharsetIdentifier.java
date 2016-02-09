package org.homenet.moonserver.kontoimporter.filehelper;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class ITestCharsetIdentifier {

	@Test
	public void test2ISO8859() throws Exception {
		final File testFile = new File("src/test/resources/org/homenet/moonserver/kontoimporter/test-iso8859-15.csv");
		final CharsetIdentifier identifier = new CharsetIdentifier(testFile);

		Assert.assertEquals("ISO-8859-1", identifier.identify());
	}

	@Test
	public void test2UTF_8() throws Exception {
		final File testFile = new File("src/test/resources/org/homenet/moonserver/kontoimporter/test2012.csv");
		final CharsetIdentifier identifier = new CharsetIdentifier(testFile);

		Assert.assertEquals("UTF-8", identifier.identify());
	}
}
