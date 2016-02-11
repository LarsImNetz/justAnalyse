package apache;

import java.io.File;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public class VHostDirectoryReader {
	private static final String BASE_FOLDER = "src/test/resources/apache/drk/vhost.d";

	public Collection<Object[]> findAllVHostFiles() {
		final File baseFolder = new File(BASE_FOLDER);
		final List<Object[]> configurationFiles = Lists.newArrayList();

		for (final File configurationFile : baseFolder.listFiles(new ConfFilenameFilter())) {
			configurationFiles.add(new Object[] {configurationFile, configurationFile.getName()});
		}
		return configurationFiles;
	}
}
