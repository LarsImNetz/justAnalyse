package org.homenet.moonserver.kontoimporter;

public class CSVBuchungFormat1 implements Buchung {
	// Buchungstag;Wert;Verwendungszweck;Soll;Haben;Waehrung

	private final String buchungsTag;
	private final double wert;
	private final String verwendungsZweck;
	private final double soll;
	private final double haben;
	private final String waehrung;
	
	public CSVBuchungFormat1(
			String buchungsTag,
			double wert,
			String verwendungsZweck,
			double soll,
			double haben,
			String waehrung
) {
		this.buchungsTag = buchungsTag;
		this.wert = wert;
		this.verwendungsZweck = verwendungsZweck;
		this.soll = soll;
		this.haben = haben;
		this.waehrung = waehrung;
	
	}

}
