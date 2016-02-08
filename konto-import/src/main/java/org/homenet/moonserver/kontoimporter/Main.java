package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

public class Main {

	public Main() {
	}

	public static void main(final String[] args) {
		final Main main = new Main();
		main.importing();
	}

	public void importing() {
		String baseFolder = System.getProperty("user.home") + "/download/konto";
		File baseFolderFile = new File(baseFolder);
		final CSVDirectoryReader reader = new CSVDirectoryReader(baseFolderFile, new DBCSVFilenameFilter());
		final Collection<Object[]> csvFiles = reader.findAllCSVFiles();

		final Iterator<Object[]> iterator = csvFiles.iterator();

		while (iterator.hasNext()) {
			final Object[] csvFileObject = iterator.next();
			final File csvFile = (File) csvFileObject[0];

			final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(csvFile);
			final List<IBuchung> buchungen = interpreter.interpret();
			// TODO: alle Buchungen in einer Liste halten
			// TODO: für alle Buchungen Zugriffe per Datum erlauben
		}
	}
}
