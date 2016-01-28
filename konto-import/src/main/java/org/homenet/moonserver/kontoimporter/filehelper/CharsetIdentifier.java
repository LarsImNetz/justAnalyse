package org.homenet.moonserver.kontoimporter.filehelper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharsetIdentifier {

	private final File file;
	private static Logger LOGGER = LoggerFactory.getLogger(CharsetIdentifier.class);
	
	public CharsetIdentifier(final File file) {
		this.file = file;
	}

	public String identify()  {
		try {
		if (determineISO_8859()) {
			return "ISO-8859-1";
		}
		} catch (final IOException e) {
			LOGGER.warn("Kann mit dem übergebenen File nichts anfangen: " + e.getMessage());
		}
		return "UTF-8";
	}

/* HÄSSLICH! */
	private boolean determineISO_8859() throws IOException {
		final byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);

		final byte ae = "ä".getBytes("ISO8859-1")[0];
		final byte oe = "ö".getBytes("ISO8859-1")[0];
		final byte ue = "ü".getBytes("ISO8859-1")[0];
		final byte Ae = "Ä".getBytes("ISO8859-1")[0];
		final byte Oe = "Ö".getBytes("ISO8859-1")[0];
		final byte Ue = "Ü".getBytes("ISO8859-1")[0];
		final byte SZ = "ß".getBytes("ISO8859-1")[0];
		final byte EUR = "€".getBytes("ISO8859-1")[0];

		int nonAscii = 0;
		int ascii = 0;
		int umlaut = 0;

		for (int i = 0; i < readFileToByteArray.length; i++) {
			final byte aByte = readFileToByteArray[i];
			if (aByte == ae) {
				umlaut++;// System.out.println("ä erkannt");
			}
			else if (aByte == oe) {
				umlaut++; // System.out.println("ö erkannt");
			}
			else if (aByte == ue) {
				umlaut++; // System.out.println("ü erkannt");
			}
			else if (aByte == Ae) {
				umlaut++; // System.out.println("Ä erkannt");
			}
			else if (aByte == Oe) {
				umlaut++;// System.out.println("Ö erkannt");
			}
			else if (aByte == Ue) {
				umlaut++; // System.out.println("Ü erkannt");
			}
			else if (aByte == SZ) {
				umlaut++; // System.out.println("ß erkannt");
			}
			else if (aByte == EUR) {
				umlaut++; // System.out.println("€ erkannt");
			}
			else if (aByte >= 0 && aByte <= 127) {
				ascii++;
			}
			else {
				nonAscii++;
			}
		}
		if (umlaut > 0) {
			return true;
		}
		return false;
	}
}
