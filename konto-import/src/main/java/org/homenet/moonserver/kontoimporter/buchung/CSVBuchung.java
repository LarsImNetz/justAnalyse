package org.homenet.moonserver.kontoimporter.buchung;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

class CSVBuchung implements IBuchung {
	// Buchungstag;Wert;Verwendungszweck;Soll;Haben;Waehrung

	private final DateTime buchungsdatum;
	private final DateTime wert;
	private final String verwendungszweck;
	private final Double soll;
	private final Double haben;
	private final String waehrung;

	public CSVBuchung(
			final DateTime buchungsdatum,
			final DateTime wert,
			final String verwendungszweck,
			final Double soll,
			final Double haben,
			final String waehrung) {
		this.buchungsdatum = buchungsdatum;
		this.wert = wert;
		this.verwendungszweck = verwendungszweck;
		this.soll = soll;
		this.haben = haben;
		this.waehrung = waehrung;
	}

	public CSVBuchung(final String[] split) {
		this.buchungsdatum = getLocaleDate(split[0]);
		this.wert = getLocaleDate(split[1]);
		this.verwendungszweck = split[2];
		this.soll = getLocaleValue(split[3]);
		this.haben = getLocaleValue(split[4]);
		this.waehrung = split[5];
	}

	static DateTime getLocaleDate(final String value) {
		final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
		final DateTime dt = formatter.parseDateTime(value);
		return dt;
	}
	
	static Double getLocaleValue(final String value) {
		final NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
		try {
			final Number number = format.parse(value);
			final double d = number.doubleValue();
			return d;
		}
		catch (final ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}

	@Override
	public Double getSoll() {
		return soll;
	}

	@Override
	public Double getHaben() {
		return haben;
	}

	@Override
	public DateTime getBuchungsdatum() {
		return buchungsdatum;
	}

	@Override
	public String getVerwendungszweck() {
		return verwendungszweck;
	}

}
