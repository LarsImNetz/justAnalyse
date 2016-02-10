package org.homenet.moonserver.kontoimporter.buchung;


public interface ICSVBuchungFactory {

	BuchungFormatEnum create(final String headerLine);
		IBuchung create(final BuchungFormatEnum format, final String[] split);
}
