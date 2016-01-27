package org.homenet.moonserver.kontoimporter.buchung;


public class CSVLineSplitter {
	public String[] split(final String line) {
		if (line == null) {
			return null;
		}
		final String[] split = line.split(";");
		return reformat(split);
	}
	
	private String[] reformat(final String[] split) {
		
		for (int i=0; i<split.length;i++) {
			final String current = split[i];
			if (current.startsWith("\"") && current.endsWith("\"")) {
				split[i] = current.substring(1, current.length() - 1);
			}
		}
		return split;
	}
}
