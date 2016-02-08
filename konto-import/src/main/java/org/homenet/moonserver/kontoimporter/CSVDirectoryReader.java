package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CSVDirectoryReader {
	private final File baseFolder;
	private final FilenameFilter filter;
	
	public CSVDirectoryReader(File baseFolder, FilenameFilter filter) {
		this.baseFolder = baseFolder;
		this.filter = filter;
	}

	public Collection<Object[]> findAllCSVFiles() {
		final List<Object[]> csvFiles = new ArrayList<>();

		for (final File csvFile : baseFolder.listFiles(this.filter)) {
			csvFiles.add(new Object[] { csvFile, csvFile.getName() });
		}
		return csvFiles;
	}
}
