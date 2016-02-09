package org.homenet.moonserver.kontoimporter.buchung;

class CSVBuchungFormat1 extends CSVBuchung /* implements CSVBuchungspruefung */  {
	// Buchungstag;Wert;Verwendungszweck;Soll;Haben;Waehrung

	public CSVBuchungFormat1(final String[] split) {
		super(split);
	}


	public static BuchungFormatEnum check(final String line) {
		if (line.equals("Buchungstag;Wert;Verwendungszweck;Soll;Haben;Waehrung")) {
			return BuchungFormatEnum.format1;
		}
		else if (line.equals("Buchungstag;Wert;Verwendungszweck;Soll;Haben;Währung")) {
			return BuchungFormatEnum.format2012;
		}
		return null;
	}

}
