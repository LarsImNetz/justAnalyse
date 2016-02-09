package org.homenet.moonserver.kontoimporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
		this.lineHandler = new LineHandler(new CSVLineSplitter());
	}

	private int lineNumber = 1;

	public List<IBuchung> interpret() {
		List<IBuchung> buchungen = null;
		String charset = null;
		try {
			final CharsetIdentifier charsetIdentifier = new CharsetIdentifier(file);
			charset = charsetIdentifier.identify();
		}
		catch (IOException e) {
			LOGGER.error("Can't read file: " + file.getAbsolutePath() + " with " + e.getMessage());
			return null;
		}
		try (
				FileInputStream inputStream = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset /* "ISO-8859-1" */))) {

			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				currentLine = reformat(currentLine);
				final String trimmedLine = currentLine.trim();

				final IBuchung buchung = lineHandler.handleCurrentLine(trimmedLine, lineNumber);
				if (buchung != null) {
					if (buchungen == null) {
						buchungen = new ArrayList<>();
					}
					buchungen.add(buchung);
				}
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

	private String reformat(final String line) {
		// currentLine = new String(currentLine.getBytes(), "ISO-8859-1");
		if (line.contains("ä") || line.contains("ö") || line.contains("ü") || line.contains("ß") || line.contains("Ä") || line.contains("Ö")
				|| line.contains("Ü")) {
			return line;
		}

		String currentLine;
		try {
			currentLine = new String(line.getBytes(), "ISO-8859-1");
			return currentLine;
		}
		catch (final UnsupportedEncodingException e) {
			LOGGER.warn("can't convert ISO-8859 to UTF-8: " + line);
		}
		return line;
	}

	// TODO: Das funktioniert nur solange bis im String ein Semikolon vorkommt.
	// TODO: Test nötig!
	String[] linesplitter(final String line) {
		return line.split(";");
	}
}
