package de.vergleich.sample.converter;

import java.util.Locale;

import org.apache.wicket.util.convert.converter.AbstractConverter;

public class DoubleWicketConverter extends AbstractConverter<Double> {

	private final DoubleConverter converter = new DoubleConverter();

	@Override
	public Double convertToObject(String value, Locale locale) {
		try {
			return converter.convert(value, locale);
		}
		catch (IllegalArgumentException e) {
			throw newConversionException(e.getMessage(), value, locale);
		}
	}

	@Override
	public String convertToString(Double betrag, Locale locale) {
		return converter.convert(betrag, locale);
	}

	@Override
	protected Class<Double> getTargetType() {
		return Double.class;
	}
}
