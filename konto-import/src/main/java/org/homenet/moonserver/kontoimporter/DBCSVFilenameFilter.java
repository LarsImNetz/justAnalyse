package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.io.FilenameFilter;

public class DBCSVFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(final File f, final String s) {
		final File currentFile = new File(f, s);

		// Hier koennen bestimmte Tests von der Ausfuehrung ausgenommen werden
		//		if (currentFile.isFile() && s.toLowerCase().endsWith("immobilienbesitz.xml")) {
		//			return false;
		//		}

		return currentFile.isFile() && s.startsWith("Kontoumsaetze_730_624768800") && s.toLowerCase().endsWith(".csv");
	}
}
