package de.vergleich.sample.converter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DoubleConverter implements Converter<Double> {

	@Override
	public Double convert(String text, Locale locale) {
		final Double num;
		try {
			num = DecimalFormat.getInstance(locale).parse(text).doubleValue();
		}
		catch (ParseException e) {
			throw new IllegalArgumentException("Could not parse String:" + text + " to Double", e);
		}

		return num;
	}

	@Override
	public String convert(Double note, Locale locale) {
		if (note == null) {
			return "";
		}

		final NumberFormat formatter = DecimalFormat.getInstance(locale);
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		formatter.setGroupingUsed(true);
		final String value = formatter.format(note);
		return value;
	}

}
