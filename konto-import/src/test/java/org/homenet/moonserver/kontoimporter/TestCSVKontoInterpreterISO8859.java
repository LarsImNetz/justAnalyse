package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.homenet.moonserver.kontoimporter.filehelper.CharsetIdentifier;
import org.junit.Assert;
import org.junit.Test;

public class TestCSVKontoInterpreterISO8859 {

	private final File testFile = new File("src/test/resources/org/homenet/moonserver/kontoimporter/test-iso8859-15.csv");
	private final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(testFile);

	@Test
	public void testTestFileExists() {
		Assert.assertTrue(testFile.exists());
	}

	@Test
	public void testKannLesen() {
		final List<IBuchung> buchungen = interpreter.interpret();

		Assert.assertEquals(1, buchungen.size());
	}

	@Test
	public void testName() throws Exception {
		final CharsetIdentifier identifier = new CharsetIdentifier(testFile);
		Assert.assertEquals("ISO-8859-1", identifier.identify());
	}

}
