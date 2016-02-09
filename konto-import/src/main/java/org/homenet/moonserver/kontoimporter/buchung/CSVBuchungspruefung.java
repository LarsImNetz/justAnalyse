package org.homenet.moonserver.kontoimporter.buchung;


public interface CSVBuchungspruefung {
	public BuchungFormatEnum check(String line);
}
