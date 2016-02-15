package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.io.FilenameFilter;

public class LarsDeutscheBankCSVFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(final File f, final String s) {
		final File currentFile = new File(f, s);

		return currentFile.isFile() && s.startsWith("Kontoumsaetze_730_624768800") && s.toLowerCase().endsWith(".csv");
	}
}
