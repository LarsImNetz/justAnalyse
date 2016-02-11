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
		DateTime dt = formatter.parseDateTime(value);
		int year = dt.getYear();
		// Patch für zu kleine Jahre
		if (year < 20) {
			year += 2000;
			int month = dt.getMonthOfYear();
			int day = dt.getDayOfMonth();
			dt = new DateTime(year, month, day, 0,0);
		}
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
		return 0d;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buchungsdatum == null)
				? 0
				: buchungsdatum.hashCode());
		result = prime * result + ((haben == null)
				? 0
				: haben.hashCode());
		result = prime * result + ((soll == null)
				? 0
				: soll.hashCode());
		result = prime * result + ((verwendungszweck == null)
				? 0
				: verwendungszweck.hashCode());
		result = prime * result + ((waehrung == null)
				? 0
				: waehrung.hashCode());
		result = prime * result + ((wert == null)
				? 0
				: wert.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CSVBuchung other = (CSVBuchung) obj;
		if (buchungsdatum == null) {
			if (other.buchungsdatum != null)
				return false;
		}
		else if (!buchungsdatum.equals(other.buchungsdatum))
			return false;
		if (haben == null) {
			if (other.haben != null)
				return false;
		}
		else if (!haben.equals(other.haben))
			return false;
		if (soll == null) {
			if (other.soll != null)
				return false;
		}
		else if (!soll.equals(other.soll))
			return false;
		if (verwendungszweck == null) {
			if (other.verwendungszweck != null)
				return false;
		}
		else if (!verwendungszweck.equals(other.verwendungszweck))
			return false;
		if (waehrung == null) {
			if (other.waehrung != null)
				return false;
		}
		else if (!waehrung.equals(other.waehrung))
			return false;
		if (wert == null) {
			if (other.wert != null)
				return false;
		}
		else if (!wert.equals(other.wert))
			return false;
		return true;
	}

	@Override
	public int compareTo(IBuchung other) {
		return buchungsdatum.compareTo(other.getBuchungsdatum());
	}

	@Override
	public String toString() {
		return "CSVBuchung [buchungsdatum=" + buchungsdatum + ", verwendungszweck=" + verwendungszweck + ", soll=" + soll + ", haben=" + haben + "]";
	}

}
