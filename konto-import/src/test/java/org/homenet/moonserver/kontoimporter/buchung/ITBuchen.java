package org.homenet.moonserver.kontoimporter.buchung;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.homenet.moonserver.kontoimporter.CSVDirectoryReader;
import org.homenet.moonserver.kontoimporter.CSVKontoInterpreter;
import org.junit.Assert;
import org.junit.Test;


public class ITBuchen {

	// Wir laufen alles durch, es gibt in jeder Datei in jedem Format Buchungen
	
	@Test
	public void testBuchen() {
		final CSVDirectoryReader reader = new CSVDirectoryReader(
				"src/test/resources/org/homenet/moonserver/kontoimporter");
		final Collection<Object[]> csvFiles = reader.findAllCSVFiles();

		Assert.assertEquals(4, csvFiles.size());

		final Iterator<Object[]> iterator = csvFiles.iterator();
		while (iterator.hasNext()) {
			final Object[] csvFileObject = iterator.next();			
			final File csvFile = (File)csvFileObject[0];		
		
			final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(csvFile);
			// TODO: Warum liefere ich eine Buchung, wenn es nicht wirklich importiert werden kann? 
			final List<Buchung> buchungen = interpreter.interpret();

			Assert.assertNotNull(buchungen);
		}
	}
}
