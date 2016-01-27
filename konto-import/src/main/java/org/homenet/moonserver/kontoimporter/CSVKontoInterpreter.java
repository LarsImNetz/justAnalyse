package org.homenet.moonserver.kontoimporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.homenet.moonserver.kontoimporter.buchung.CSVLineSplitter;
import org.homenet.moonserver.kontoimporter.buchung.LineHandler;
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

		try (FileInputStream inputStream = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
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
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	// TODO: Das funktioniert nur solange bis im String ein Semikolon vorkommt.
	// TODO: Test nötig!
	String[] linesplitter(final String line) {
		return line.split(";");
	}
}
