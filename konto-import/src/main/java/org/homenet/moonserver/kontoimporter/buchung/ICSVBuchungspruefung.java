package org.homenet.moonserver.kontoimporter.buchung;

public interface ICSVBuchungspruefung {

	public BuchungFormatEnum check(String line);
}
