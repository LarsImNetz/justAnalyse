package experiment.lars.java.path;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

import com.google.common.base.Preconditions;

public class PathProvider {

	private final String jobFileName;
	// private final String jobConfigFileName;

	public PathProvider(final String... job) {
		Preconditions.checkNotNull(job);
		Preconditions.checkArgument(job.length >= 1);

		final Path jobDirectory = determineJobDirectory(new File("").getAbsoluteFile(), job);
		Preconditions.checkArgument(jobDirectory != null, "Job " + Arrays.toString(job) + " nicht gefunden.");

		final Path jobConfigPath = jobDirectory.resolve("config-test.properties");
		Preconditions.checkArgument(jobConfigPath.toFile().isFile(), "Konfiguration " + jobConfigPath.toString() + " nicht gefunden.");

		jobFileName = jobDirectory.resolve(job[job.length - 1]).toString();
		// jobConfigFileName = jobConfigPath.toString();
	}

	public String getJobFileName() {
		return jobFileName;
	}

	private Path determineJobDirectory(final File directory, final String... job) {
		final File[] list = directory.listFiles();

		for (final File l : list) {
			final String name = l.getName();
			if (name.equals(job[0])) {
				if (l.isDirectory()) {
					final Path pathToJob = appendJobToPath(directory.toPath(), job[0]);

					if (pathToJob.toFile().isDirectory()) {
						return determineJobDirectory(pathToJob.toFile(), cdr(job));
					}
					else {
						return null;
					}
				}
				if (l.isFile()) {
					return directory.toPath();
				}
			}
		}

		if (directory.getParentFile() != null) {
			return determineJobDirectory(directory.getParentFile(), job);
		}

		return null;
	}

	private String[] cdr(final String... strings) {
		if (strings == null || strings.length == 0) {
			throw new IllegalArgumentException("Array sollte mindestens ein Element enthalten");
		}

		final String[] newStrings = new String[strings.length - 1];
		for (int i = 1; i < strings.length; i++) {
			newStrings[i - 1] = strings[i];
		}
		return newStrings;
	}

	private Path appendJobToPath(final Path path, final String job) {
		final Path current = path.resolve(job);
		return current.toAbsolutePath();
	}
}
