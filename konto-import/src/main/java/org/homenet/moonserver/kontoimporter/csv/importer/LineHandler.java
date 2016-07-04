package org.homenet.moonserver.kontoimporter.csv.importer;

import org.homenet.moonserver.kontoimporter.buchung.BuchungFormatEnum;
import org.homenet.moonserver.kontoimporter.buchung.CSVBuchungFactory;
import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: schlechte Implementierung, hier sollte ich mir etwas anderes überlegen
public class LineHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(LineHandler.class);

	private final CSVLineSplitter linesplitter;
	private final CSVBuchungFactory csvBuchungFactory;

	public LineHandler(final CSVLineSplitter linesplitter, final CSVBuchungFactory csvBuchungFactory) {
		this.linesplitter = linesplitter;
		this.csvBuchungFactory = csvBuchungFactory;
	}

	private BuchungFormatEnum format = null;

	public IBuchung handleCurrentLine(final String line, final int lineNumber) {
		if (format == null) {
			initialiseBuchungsformat(line, lineNumber);
		}
		else {
			final IBuchung buchung = createBuchungFrom(line, lineNumber);
			return buchung;
		}
		return null;
	}

	public BuchungFormatEnum getFormat() {
		return format;
	}

	public void setFormat(final BuchungFormatEnum format) {
		this.format = format;
	}

	private IBuchung createBuchungFrom(final String line, final int lineNumber) {
		try {
			final String[] split = linesplitter.split(line); // !SRP?
			return csvBuchungFactory.create(format, split);
		}
		catch (final IllegalArgumentException e) {
			// Beim Versuch die Buchung zu interpretieren ist ein Fehler aufgetreten!
			LOGGER.warn("Kann die Zeile: " + lineNumber + " nicht interpretieren: " + line + " Exception:" + e.getMessage());
		}
		return null;
	}

	private void initialiseBuchungsformat(final String line, final int lineNumber) {
		format = csvBuchungFactory.create(line);

		if (format == null) {
			// das ist jetzt zwar illegal, sollte aber erstmal nicht weiter stören
			LOGGER.warn("Format noch nicht erkannt. Zeile: " + lineNumber + " Content: " + line);
		}
	}
}
