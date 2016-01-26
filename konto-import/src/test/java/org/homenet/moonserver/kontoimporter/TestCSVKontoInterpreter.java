package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.Buchung;
import org.junit.Assert;
import org.junit.Test;

public class TestCSVKontoInterpreter {

	private final File testFile = new File("src/test/resources/org/homenet/moonserver/kontoimporter/test.csv");
	private final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(testFile);

	@Test
	public void testTestFileExists() {
		Assert.assertTrue(testFile.exists());
	}

	@Test
	public void testKannLesen() {
		final List<Buchung> buchungen = interpreter.interpret();

		Assert.assertEquals(3, buchungen.size());
	}
	
}
