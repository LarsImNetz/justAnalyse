package org.homenet.moonserver.kontoimporter.buchung;

class CSVBuchungFormat2015 extends CSVBuchung /* implements CSVBuchungspruefung */ {

	// Buchungstag;Wert;Umsatzart;Begünstigter / Auftraggeber;Verwendungszweck;IBAN;BIC;Kundenreferenz;Mandatsreferenz ;Gläubiger ID;Fremde Gebühren;Betrag;Abweichender Empfänger;Anzahl der Aufträge;Soll;Haben;Währung
	// 0           1    2         3                           4                5    6   7              8                9            10              11     12                     13                  14   15    16
	public CSVBuchungFormat2015(final String[] split) {
		super(getLocaleDate(split[0]), getLocaleDate(split[1]), split[4], getLocaleValue(split[14]), getLocaleValue(split[15]), split[16]);
	}

	public static BuchungFormatEnum check(final String line) {
		if (line.equals(
				"Buchungstag;Wert;Umsatzart;Begünstigter / Auftraggeber;Verwendungszweck;IBAN;BIC;Kundenreferenz;Mandatsreferenz ;Gläubiger ID;Fremde Gebühren;Betrag;Abweichender Empfänger;Anzahl der Aufträge;Soll;Haben;Währung")) {
			return BuchungFormatEnum.format2015;
		}
		return null;
	}
}
