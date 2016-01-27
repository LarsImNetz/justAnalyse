package org.homenet.moonserver.kontoimporter.buchung;

class CSVBuchungFormat1 extends CSVBuchung {
	// Buchungstag;Wert;Verwendungszweck;Soll;Haben;Waehrung

	public CSVBuchungFormat1(final String[] split) {
		super(split);
	}

}
