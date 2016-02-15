package org.homenet.moonserver.kontoimporter.csv.importer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVLineSplitter {

	private static Logger LOGGER = LoggerFactory.getLogger(CSVLineSplitter.class);

	public String[] split(final String line) {
		if (line == null) {
			return null;
		}
		final String[] split = line.split(";");
		return reformat(split);
	}

	private String[] reformat(final String[] split) {

		for (int i = 0; i < split.length; i++) {
			final String current = split[i];
			if (current.startsWith("\"") && current.endsWith("\"")) {
				split[i] = current.substring(1, current.length() - 1);
			}
			else if (current.startsWith("\"")) {
				LOGGER.warn("String beginnt mit double quote, ende aber nicht.");
			}
			else if (current.endsWith("\"")) {
				LOGGER.warn("String endet mit double quote, startet damit aber nicht.");
			}
		}
		return split;
	}
}
