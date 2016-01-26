package org.homenet.moonserver.kontoimporter.buchung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LineHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(LineHandler.class);

	private final CSVLineSplitter linesplitter;

	public LineHandler(final CSVLineSplitter linesplitter) {
		this.linesplitter = linesplitter;
	}

	private BuchungFormatEnum format = null;

	public Buchung handleCurrentLine(final String line, final int lineNumber) {
		try {
			Buchung buchung = null;
			if (line.equals("Buchungstag;Wert;Verwendungszweck;Soll;Haben;Waehrung")) {
				format = BuchungFormatEnum.format1;
			}
			else if (format == null) {
				// das ist jetzt zwar illegal, sollte aber erstmal nicht weiter stören
				LOGGER.warn("Format noch nicht erkannt. Zeile: " + lineNumber + " Content: " + line);
			}
			else if (format == BuchungFormatEnum.format1) {
				buchung = new CSVBuchungFormat1(linesplitter.split(line));
			}
			return buchung;
		}
		catch (final IllegalArgumentException e) {
			// Beim Versuch die Buchung zu interpretieren ist ein Fehler aufgetreten!
			LOGGER.warn("Kann die Zeile: " + lineNumber + " nicht interpretieren: " + line + " Exception:" + e.getMessage());
		}
		return null;
	}
}
