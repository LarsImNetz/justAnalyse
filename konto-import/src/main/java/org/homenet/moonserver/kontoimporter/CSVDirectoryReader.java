package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CSVDirectoryReader {
	private final String BASE_FOLDER;

	public CSVDirectoryReader(String baseFolder) {
		BASE_FOLDER = baseFolder;
	}

	public Collection<Object[]> findAllVHostFiles() {
		final File baseFolder = new File(BASE_FOLDER);
		final List<Object[]> csvFiles = new ArrayList<>();

		for (final File csvFile : baseFolder.listFiles(new CSVFilenameFilter())) {
			csvFiles.add(new Object[] { csvFile, csvFile.getName() });
		}
		return csvFiles;
	}
}
