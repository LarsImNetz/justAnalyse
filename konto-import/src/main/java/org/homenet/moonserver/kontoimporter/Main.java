package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public Main() {
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.importing();
	}

	public void importing() {
		final CSVDirectoryReader reader = new CSVDirectoryReader(
				"/home/lars/download/konto", new DBCSVFilenameFilter());
		final Collection<Object[]> csvFiles = reader.findAllCSVFiles();

		final Iterator<Object[]> iterator = csvFiles.iterator();
		while (iterator.hasNext()) {
			final Object[] csvFileObject = iterator.next();
			final File csvFile = (File)csvFileObject[0];
		
			final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(csvFile);
			final List<IBuchung> buchungen = interpreter.interpret();

		}
		
	}
}
