package luceneFive;

import java.io.File;

public class FileFinder {

	private final String fileToSearch;

	public FileFinder(final String fileToSearch) {
		this.fileToSearch = fileToSearch;
	}

	public File getFile() {
		final File absoluteFile = new File("").getAbsoluteFile();
		return searchFile(fileToSearch, absoluteFile);
	}

	private File searchFile(final String fileToSearch, final File directory) {
		final File[] files = directory.listFiles();
		for (final File file : files) {
			if (file.isDirectory()) {
				final File found = searchFile(fileToSearch, file);
				if (found != null) {
					return found;
				}
			}
			else {
				if (file.getName().equals(fileToSearch)) {
					return file;
				}
			}
		}
		return null;
	}
}
