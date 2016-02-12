package org.homenet.moonserver.kontoimporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.CSVBuchungFactory;
import org.homenet.moonserver.kontoimporter.buchung.CSVLineSplitter;
import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.homenet.moonserver.kontoimporter.buchung.LineHandler;
import org.homenet.moonserver.kontoimporter.filehelper.CharsetIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVKontoInterpreter {

	private static Logger LOGGER = LoggerFactory.getLogger(CSVKontoInterpreter.class);

	private final File file;

	private final LineHandler lineHandler;

	public CSVKontoInterpreter(final File file) {
		this.file = file;
		this.lineHandler = new LineHandler(new CSVLineSplitter(), new CSVBuchungFactory());
	}

	private int lineNumber = 1;

	public List<IBuchung> interpret() {
		List<IBuchung> buchungen = null;
		String charset = null;
		try {
			final CharsetIdentifier charsetIdentifier = new CharsetIdentifier(file);
			charset = charsetIdentifier.identify();
		}
		catch (final IOException e) {
			LOGGER.error("Can't read file: " + file.getAbsolutePath() + " with " + e.getMessage());
			return null;
		}
		try (
				FileInputStream inputStream = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset /* "ISO-8859-1" */))) {

			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				final String trimmedLine = currentLine.trim();

				final IBuchung buchung = lineHandler.handleCurrentLine(trimmedLine, lineNumber);
				buchungen = append(buchungen, buchung);
				lineNumber++;
			}

			reader.close();
			inputStream.close();
			return buchungen;
		}
		catch (final IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<IBuchung> append(List<IBuchung> buchungen, final IBuchung buchung) {
		if (buchung != null) {
			if (buchungen == null) {
				buchungen = new ArrayList<>();
			}
			buchungen.add(buchung);
		}
		return buchungen;
	}
}
