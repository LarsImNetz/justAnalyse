package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.io.FilenameFilter;

public class SimpleCSVFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		final File currentFile = new File(dir, name);

		// Hier koennen bestimmte Tests von der Ausfuehrung ausgenommen werden
		//		if (currentFile.isFile() && s.toLowerCase().endsWith("immobilienbesitz.xml")) {
		//			return false;
		//		}

		return currentFile.isFile() && name.toLowerCase().endsWith(".csv");
	}

}
