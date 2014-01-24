package de.vergleich.sample.converter;

import java.util.Locale;

public interface Converter<T> {

	abstract T convert(String value, Locale locale);

	abstract String convert(T object, Locale locale);
}
