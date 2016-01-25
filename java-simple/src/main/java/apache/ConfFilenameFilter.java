package apache;

import java.io.File;
import java.io.FilenameFilter;

public class ConfFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(final File f, final String s) {
		final File currentFile = new File(f, s);

		// Hier koennen bestimmte Tests von der Ausfuehrung ausgenommen werden
		//		if (currentFile.isFile() && s.toLowerCase().endsWith("immobilienbesitz.xml")) {
		//			return false;
		//		}

		return currentFile.isFile() && s.toLowerCase().endsWith(".conf");
	}
}
