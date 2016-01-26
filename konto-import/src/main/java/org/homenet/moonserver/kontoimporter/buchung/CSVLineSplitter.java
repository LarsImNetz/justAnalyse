package org.homenet.moonserver.kontoimporter.buchung;


public class CSVLineSplitter {
	public String[] split(final String line) {
		if (line == null) {
			return null;
		}
		return line.split(";");
	}
}
