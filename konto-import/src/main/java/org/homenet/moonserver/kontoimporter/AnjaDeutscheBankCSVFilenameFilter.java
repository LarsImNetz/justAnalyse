package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.io.FilenameFilter;

public class AnjaDeutscheBankCSVFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(final File f, final String s) {
		final File currentFile = new File(f, s);

		return currentFile.isFile() && s.startsWith("Kontoumsaetze_730_836660100") && s.toLowerCase().endsWith(".csv");
	}
}
