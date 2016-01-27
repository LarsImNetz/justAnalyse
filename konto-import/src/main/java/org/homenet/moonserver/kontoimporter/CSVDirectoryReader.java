package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CSVDirectoryReader {
	private final String BASE_FOLDER;
	private final FilenameFilter filter;
	
	public CSVDirectoryReader(String baseFolder, FilenameFilter filter) {
		BASE_FOLDER = baseFolder;
		this.filter = filter;
	}

	public Collection<Object[]> findAllCSVFiles() {
		final File baseFolder = new File(BASE_FOLDER);
		final List<Object[]> csvFiles = new ArrayList<>();

		for (final File csvFile : baseFolder.listFiles(this.filter)) {
			csvFiles.add(new Object[] { csvFile, csvFile.getName() });
		}
		return csvFiles;
	}
}
