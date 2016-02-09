package org.homenet.moonserver.kontoimporter.buchung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Grottenschlechte Implementierung, hier sollte ich mir etwas anderes überlegen
public class LineHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(LineHandler.class);

	private final CSVLineSplitter linesplitter;

	public LineHandler(final CSVLineSplitter linesplitter) {
		this.linesplitter = linesplitter;
	}

	private BuchungFormatEnum format = null;

	public IBuchung handleCurrentLine(final String line, final int lineNumber) {
		try {
			if (format == null) {

				format = CSVBuchungFactory.create(line);

				if (format == null) {
					// das ist jetzt zwar illegal, sollte aber erstmal nicht weiter stören
					LOGGER.warn("Format noch nicht erkannt. Zeile: " + lineNumber + " Content: " + line);
				}
			}
			else {
				final IBuchung buchung = CSVBuchungFactory.create(format, linesplitter.split(line));
				return buchung;
			}
		}
		catch (final IllegalArgumentException e) {
			// Beim Versuch die Buchung zu interpretieren ist ein Fehler aufgetreten!
			LOGGER.warn("Kann die Zeile: " + lineNumber + " nicht interpretieren: " + line + " Exception:" + e.getMessage());
		}
		return null;
	}
}
