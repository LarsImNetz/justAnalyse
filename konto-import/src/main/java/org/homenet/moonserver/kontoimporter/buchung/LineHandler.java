package org.homenet.moonserver.kontoimporter.buchung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Grottenschlechte Implementierung, hier sollte ich mir etwas anderes überlegen
// TODO: umstellung auf lose Kopplung, hier sollen keine C'Tors mehr genutzt werden.
public class LineHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(LineHandler.class);

	private final CSVLineSplitter linesplitter;

	public LineHandler(final CSVLineSplitter linesplitter) {
		this.linesplitter = linesplitter;
	}

	private BuchungFormatEnum format = null;

	public IBuchung handleCurrentLine(final String line, final int lineNumber) {
		try {
			IBuchung buchung = null;
			format = checkBuchungsformate(line);
			if (format == null) {
				// das ist jetzt zwar illegal, sollte aber erstmal nicht weiter stören
				LOGGER.warn("Format noch nicht erkannt. Zeile: " + lineNumber + " Content: " + line);
			}
			else if (format == BuchungFormatEnum.format1) {
				buchung = new CSVBuchungFormat1(linesplitter.split(line));
			}
			else if (format == BuchungFormatEnum.format2012) {
				buchung = new CSVBuchungFormat1(linesplitter.split(line));
			}
			else if (format == BuchungFormatEnum.format2014) {
				buchung = new CSVBuchungFormat2014(linesplitter.split(line));
			}
			else if (format == BuchungFormatEnum.format2015) {
				buchung = new CSVBuchungFormat2015(linesplitter.split(line));
			}
			return buchung;
		}
		catch (final IllegalArgumentException e) {
			// Beim Versuch die Buchung zu interpretieren ist ein Fehler aufgetreten!
			LOGGER.warn("Kann die Zeile: " + lineNumber + " nicht interpretieren: " + line + " Exception:" + e.getMessage());
		}
		return null;
	}
	
	private BuchungFormatEnum checkBuchungsformate(final String line) {
		if (this.format != null) {
			return this.format;
		}
		BuchungFormatEnum format = null;
		format = CSVBuchungFormat1.check(line);
		if (format != null ) {
			return format;
		}
		format = CSVBuchungFormat2014.check(line);
		if (format != null ) {
			return format;
		}

		format = CSVBuchungFormat2015.check(line);
		if (format != null ) {
			return format;
		}

		return null;
	}
}
