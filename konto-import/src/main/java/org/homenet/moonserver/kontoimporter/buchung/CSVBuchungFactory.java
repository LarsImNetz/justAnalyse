package org.homenet.moonserver.kontoimporter.buchung;

public class CSVBuchungFactory implements ICSVBuchungFactory {

	public CSVBuchungFactory() {
	}

	@Override
	public BuchungFormatEnum create(final String headerLine) {
		BuchungFormatEnum format = CSVBuchungFormat1.check(headerLine);
		if (format != null) {
			return format;
		}
		format = CSVBuchungFormat2014.check(headerLine);
		if (format != null) {
			return format;
		}
		format = CSVBuchungFormat2015.check(headerLine);
		if (format != null) {
			return format;
		}
		return null;
	}

	@Override
	public IBuchung create(final BuchungFormatEnum format, final String[] split) {
		switch (format) {
			case format1:
				return new CSVBuchungFormat1(split);
			case format2012:
				return new CSVBuchungFormat1(split);
			case format2014:
				return new CSVBuchungFormat2014(split);
			case format2015:
				return new CSVBuchungFormat2015(split);
		}
		return null;
	}
}
