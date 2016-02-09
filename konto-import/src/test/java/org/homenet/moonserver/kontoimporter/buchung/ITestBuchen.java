package org.homenet.moonserver.kontoimporter.buchung;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.homenet.moonserver.kontoimporter.CSVDirectoryReader;
import org.homenet.moonserver.kontoimporter.CSVKontoInterpreter;
import org.homenet.moonserver.kontoimporter.SimpleCSVFilter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Integrationstest für kontoimporter
 * Wir laufen alles durch, es gibt in jeder Datei in jedem Format Buchungen
 *
 */

public class ITestBuchen {

	private static String baseFolder = "src/test/resources/org/homenet/moonserver/kontoimporter";

	@Test
	public void testExistance() throws Exception {
		final File baseFolderFile = new File(baseFolder);
		Assert.assertTrue("base folder must exist.", baseFolderFile.exists());
	}
	
	@Test
	public void testBuchen() {
		final File baseFolderFile = new File(baseFolder);
		final CSVDirectoryReader reader = new CSVDirectoryReader(baseFolderFile, new SimpleCSVFilter());
		final Collection<Object[]> csvFiles = reader.findAllCSVFiles();

		Assert.assertEquals(5, csvFiles.size());

		final Iterator<Object[]> iterator = csvFiles.iterator();
		while (iterator.hasNext()) {
			final Object[] csvFileObject = iterator.next();
			final File csvFile = (File) csvFileObject[0];

			final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(csvFile);

			// TODO: Warum liefere ich eine Buchung, wenn es nicht wirklich importiert werden kann? 
			final List<IBuchung> buchungen = interpreter.interpret();

			Assert.assertNotNull(buchungen);
		}
	}
}
