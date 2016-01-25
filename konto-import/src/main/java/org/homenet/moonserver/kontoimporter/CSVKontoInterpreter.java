package org.homenet.moonserver.kontoimporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVKontoInterpreter {

	private static Logger LOGGER = LoggerFactory.getLogger(CSVKontoInterpreter.class);

	private final File file;

	public CSVKontoInterpreter(final File file) {
		this.file = file;
	}

	private int lineNumber = 1;

	public List<Buchung> interpret() {
		final List<Buchung> buchungen = new ArrayList<>();

		try (FileInputStream inputStream = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				final String trimmedLine = currentLine.trim();

				final Buchung virtualHost = handleCurrentLine(trimmedLine);
				if (virtualHost != null) {
					buchungen.add(virtualHost);
				}
				lineNumber++;
			}

			reader.close();
			inputStream.close();
			return buchungen;
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Buchung handleCurrentLine(final String line) {
		Buchung buchung = null;
		final String lowercaseLine = line.toLowerCase();
		String[] split = line.split(";");
		if (lowercaseLine.startsWith("")) {
		} else {
			LOGGER.warn("Unbekannter State (" + split[0] + ") in Zeile: " + lineNumber + " Content: " + line);
		}
		return buchung;
	}
}
